package com.execute;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavaClassExecutor {
	public static String execute(byte[]classByte,String systemIn) {
		ClassModifier cm=new ClassModifier(classByte);
		byte[]modifyBytes=cm.modifyUTF8Constant("java/lang/System", "com/execute/HackSystem");
		modifyBytes=cm.modifyUTF8Constant("java/util/Scanner", "com/execute/HackScanner");
		((HackInputStream)HackSystem.in).set(systemIn);
		HotSwapClassLoader classLoader=new HotSwapClassLoader();
		Class clazz=classLoader.loadByte(modifyBytes);
		try {
			Method mainMethod=clazz.getMethod("main", new Class[] {String[].class});
			mainMethod.invoke(null, new String[] {null});
		} catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
        	e.getCause().printStackTrace(HackSystem.err);
        }
		String reString=HackSystem.getBufferString();
		HackSystem.closeBuffer();
		return reString;
	}
}
