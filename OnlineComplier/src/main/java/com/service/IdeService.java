package com.service;



import org.springframework.stereotype.Service;

import com.compile.StringSourceCompiler;
import com.execute.JavaClassExecutor;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaFileObject;
import java.util.List;
import java.util.concurrent.*;

@Service
public class IdeService {
	 private static final int RUN_TIME_LIMITED = 15;

	    /* N_THREAD = N_CPU + 1，因为是 CPU 密集型的操作 */
	    private static final int N_THREAD = 5;

	    /* 负责执行客户端代码的线程池，根据《Java 开发手册》不可用 Executor 创建，有 OOM 的可能 */
	    private static final ExecutorService pool = new ThreadPoolExecutor(N_THREAD, N_THREAD,
	            0L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(N_THREAD));

	    private static final String WAIT_WARNING = "服务器忙。";
	    private static final String NO_OUTPUT = "Nothing.";

	    public String execute(String source, final String systemIn) {
	        DiagnosticCollector<JavaFileObject> compileCollector = new DiagnosticCollector<>(); // 编译结果收集器

	        // 编译源代码
	        final byte[] classBytes = StringSourceCompiler.compile(source, compileCollector);

	        // 编译不通过，获取并返回编译错误信息
	        if(classBytes==null) {
	        	
	        	List<Diagnostic<? extends JavaFileObject>>compileError=compileCollector.getDiagnostics();
	        	StringBuilder cStringBuilder=new StringBuilder();
	        	for(Diagnostic diagnostic:compileError) {
	        		cStringBuilder.append("Compilation error at ");
	        		cStringBuilder.append(diagnostic.getCode());
	        		cStringBuilder.append(" .");
	        		cStringBuilder.append(System.lineSeparator());
	        	}
	        	return cStringBuilder.toString();
	        }
	        Callable<String>runtask=new Callable<String>() {
				
				@Override
				public String call() throws Exception {
					// TODO Auto-generated method stub
					return JavaClassExecutor.execute(classBytes,systemIn);
				}
			};
	        Future<String>res=null;
	        try {
				res=pool.submit(runtask);
			} catch (RejectedExecutionException e) {
				return WAIT_WARNING;
			}
	        String runResult = null;
	        try {
				try {
					runResult=res.get(RUN_TIME_LIMITED,TimeUnit.SECONDS);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ExecutionException e) {
	            runResult = e.getCause().getMessage();
	        } catch (TimeoutException e) {
	            runResult = "Time Limit Exceeded.";
	        } finally {
	            res.cancel(true);
	        }
	        return runResult!=null?runResult:NO_OUTPUT;
	    }
}
