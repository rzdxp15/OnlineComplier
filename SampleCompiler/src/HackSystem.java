

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * 涓篔avaclass鍔寔java.lang.System鎻愪緵鏀寔
 * 闄や簡out鍜宔rr澶栵紝鍏朵綑鐨勯兘鐩存帴杞彂缁橲ystem澶勭悊
 *
 * @author zzm
 */
public class HackSystem {

    public final static InputStream in = System.in;

    private static ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    public final static PrintStream out = new PrintStream(buffer);

    public final static PrintStream err = out;

    public static String getBufferString() {
        return buffer.toString();
    }

    public static void clearBuffer() {
        buffer.reset();
    }

    public static void setSecurityManager(final SecurityManager s) {
        System.setSecurityManager(s);
    }

    public static SecurityManager getSecurityManager() {
        return System.getSecurityManager();
    }

    public static long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) {
        System.arraycopy(src, srcPos, dest, destPos, length);
    }

    public static int identityHashCode(Object x) {
        return System.identityHashCode(x);
    }

    // 涓嬮潰鎵�鏈夌殑鏂规硶閮戒笌java.lang.System鐨勫悕绉颁竴鏍�
    // 瀹炵幇閮芥槸瀛楄妭杞皟System鐨勫搴旀柟娉�
    // 鍥犵増闈㈠師鍥狅紝鐪佺暐浜嗗叾浠栨柟娉�
}
