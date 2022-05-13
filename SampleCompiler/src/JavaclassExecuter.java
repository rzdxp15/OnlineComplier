

import java.lang.reflect.Method;

/**
 * Javaclass鎵ц宸ュ叿
 *
 * @author zzm
 */
public class JavaclassExecuter {

    /**
     * 鎵ц澶栭儴浼犺繃鏉ョ殑浠ｈ〃涓�涓狫ava绫荤殑Byte鏁扮粍<br>
     * 灏嗚緭鍏ョ被鐨刡yte鏁扮粍涓唬琛╦ava.lang.System鐨凜ONSTANT_Utf8_info甯搁噺淇敼涓哄姭鎸佸悗鐨凥ackSystem绫�
     * 鎵ц鏂规硶涓鸿绫荤殑static main(String[] args)鏂规硶锛岃緭鍑虹粨鏋滀负璇ョ被鍚慡ystem.out/err杈撳嚭鐨勪俊鎭�
     *
     * @param classByte 浠ｈ〃涓�涓狫ava绫荤殑Byte鏁扮粍
     * @return 鎵ц缁撴灉
     */
    public static String execute(byte[] classByte) {
        HackSystem.clearBuffer();
        ClassModifier cm = new ClassModifier(classByte);
        byte[] modiBytes = cm.modifyUTF8Constant("java/lang/System", "org/fenixsoft/classloading/execute/HackSystem");
        HotSwapClassLoader loader = new HotSwapClassLoader();
        Class clazz = loader.loadByte(modiBytes);
        try {
            Method method = clazz.getMethod("main", new Class[]{String[].class});
            method.invoke(null, new String[]{null});
        } catch (Throwable e) {
            e.printStackTrace(HackSystem.out);
        }
        return HackSystem.getBufferString();
    }
}
