

/**
 * 淇敼Class鏂囦欢锛屾殏鏃跺彧鎻愪緵淇敼甯搁噺姹犲父閲忕殑鍔熻兘
 *
 * @author zzm
 */
public class ClassModifier {

    /**
     * Class鏂囦欢涓父閲忔睜鐨勮捣濮嬪亸绉�
     */
    private static final int CONSTANT_POOL_COUNT_INDEX = 8;

    /**
     * CONSTANT_Utf8_info甯搁噺鐨則ag鏍囧織
     */
    private static final int CONSTANT_Utf8_info = 1;

    /**
     * 甯搁噺姹犱腑11绉嶅父閲忔墍鍗犵殑闀垮害锛孋ONSTANT_Utf8_info鍨嬪父閲忛櫎澶栵紝鍥犱负瀹冧笉鏄畾闀跨殑
     */
    private static final int[] CONSTANT_ITEM_LENGTH = {-1, -1, -1, 5, 5, 9, 9, 3, 3, 5, 5, 5, 5};

    private static final int u1 = 1;
    private static final int u2 = 2;

    private byte[] classByte;

    public ClassModifier(byte[] classByte) {
        this.classByte = classByte;
    }

    /**
     * 淇敼甯搁噺姹犱腑CONSTANT_Utf8_info甯搁噺鐨勫唴瀹�
     *
     * @param oldStr 淇敼鍓嶇殑瀛楃涓�
     * @param newStr 淇敼鍚庣殑瀛楃涓�
     * @return 淇敼缁撴灉
     */
    public byte[] modifyUTF8Constant(String oldStr, String newStr) {
        int cpc = getConstantPoolCount();
        int offset = CONSTANT_POOL_COUNT_INDEX + u2;
        for (int i = 0; i < cpc; i++) {
            int tag = ByteUtils.bytes2Int(classByte, offset, u1);
            if (tag == CONSTANT_Utf8_info) {
                int len = ByteUtils.bytes2Int(classByte, offset + u1, u2);
                offset += (u1 + u2);
                String str = ByteUtils.bytes2String(classByte, offset, len);
                if (str.equalsIgnoreCase(oldStr)) {
                    byte[] strBytes = ByteUtils.string2Bytes(newStr);
                    byte[] strLen = ByteUtils.int2Bytes(newStr.length(), u2);
                    classByte = ByteUtils.bytesReplace(classByte, offset - u2, u2, strLen);
                    classByte = ByteUtils.bytesReplace(classByte, offset, len, strBytes);
                    return classByte;
                } else {
                    offset += len;
                }
            } else {
                offset += CONSTANT_ITEM_LENGTH[tag];
            }
        }
        return classByte;
    }

    /**
     * 鑾峰彇甯搁噺姹犱腑甯搁噺鐨勬暟閲�
     *
     * @return 甯搁噺姹犳暟閲�
     */
    public int getConstantPoolCount() {
        return ByteUtils.bytes2Int(classByte, CONSTANT_POOL_COUNT_INDEX, u2);
    }
}
