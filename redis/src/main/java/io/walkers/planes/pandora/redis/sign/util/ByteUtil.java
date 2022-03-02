package io.walkers.planes.pandora.redis.sign.util;

/**
 * 字节工具类
 *
 * @author planeswalker23
 * @date 2022/2/26
 */
public class ByteUtil {

    private static final char falseChar = '0';
    private static final char tureChar = '1';

    /**
     * 将字节转化为8位布尔数组
     *
     * @param source 来源字节
     * @return boolean[]
     */
    public static boolean[] getBooleanArrayFromByte(byte source) {
        boolean[] array = new boolean[8];
        for (int i = 7; i >= 0; i--) {
            // 判定byte的最后一位是否为1，若为1，则是true；否则是false
            array[i] = (source & 1) == 1;
            // byte右移一位
            source = (byte) (source >> 1);
        }
        return array;
    }

    /**
     * 将字节转化为8位字符数组
     *
     * @param source 来源字节
     * @return boolean[]
     */
    public static char[] getCharArrayFromByte(byte source) {
        char[] array = new char[8];
        for (int i = 7; i >= 0; i--) {
            // 判定byte的最后一位是否为1，若为1，则是true；否则是false
            array[i] = (source & 1) == 1 ? tureChar : falseChar;
            // byte右移一位
            source = (byte) (source >> 1);
        }
        return array;
    }

    /**
     * 将字节转化为以0-1表示的字符串
     *
     * @param source 来源字节
     * @return String
     */
    public static String getStringFormByte(byte source) {
        char[] charArray = getCharArrayFromByte(source);
        return new String(charArray);
    }

    /**
     * 将字节数组转化为以0-1表示的字符串
     *
     * @param source 来源字节数组
     * @return String
     */
    public static String getStringFormByteArray(byte[] source) {
        if (source == null) {
            return getStringFormByte((byte) 0);
        } else {
            StringBuilder resultBuilder = new StringBuilder();
            for (int i = 0; i < source.length; i++) {
                char[] charArray = getCharArrayFromByte(source[i]);
                resultBuilder.append(charArray);
            }
            return resultBuilder.toString();
        }
    }

    /**
     * 将8位布尔数组转化位 byte
     *
     * @param source 来源布尔数组
     * @return byte
     */
    public static byte getByteFromBooleanArray(boolean[] source) {
        if (source != null && source.length > 0) {
            byte b = 0;
            for (int i = 0; i <= 7; i++) {
                if (source[i]) {
                    int nn = (1 << (7 - i));
                    b += nn;
                }
            }
            return b;
        }
        return 0;
    }
}
