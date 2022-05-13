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

	    /* N_THREAD = N_CPU + 1����Ϊ�� CPU �ܼ��͵Ĳ��� */
	    private static final int N_THREAD = 5;

	    /* ����ִ�пͻ��˴�����̳߳أ����ݡ�Java �����ֲᡷ������ Executor �������� OOM �Ŀ��� */
	    private static final ExecutorService pool = new ThreadPoolExecutor(N_THREAD, N_THREAD,
	            0L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(N_THREAD));

	    private static final String WAIT_WARNING = "������æ��";
	    private static final String NO_OUTPUT = "Nothing.";

	    public String execute(String source, final String systemIn) {
	        DiagnosticCollector<JavaFileObject> compileCollector = new DiagnosticCollector<>(); // �������ռ���

	        // ����Դ����
	        final byte[] classBytes = StringSourceCompiler.compile(source, compileCollector);

	        // ���벻ͨ������ȡ�����ر��������Ϣ
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
