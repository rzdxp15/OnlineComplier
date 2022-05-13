

/**
 * 涓轰簡澶氭杞藉叆鎵ц绫昏�屽姞鍏ョ殑鍔犺浇鍣�
 * 鎶奷efineClass鏂规硶寮�鏀惧嚭鏉ワ紝鍙湁澶栭儴鏄惧紡璋冪敤鐨勬椂鍊欐墠浼氫娇鐢ㄥ埌loadByte鏂规硶
 * 鐢辫櫄鎷熸満璋冪敤鏃讹紝浠嶇劧鎸夌収鍘熸湁鐨勫弻浜插娲捐鍒欎娇鐢╨oadClass鏂规硶杩涜绫诲姞杞�
 *
 * @author zzm
 */
public class HotSwapClassLoader extends ClassLoader {

    public HotSwapClassLoader() {
        super(HotSwapClassLoader.class.getClassLoader());
    }

    public Class loadByte(byte[] classByte) {
        return defineClass(null, classByte, 0, classByte.length);
    }

}
