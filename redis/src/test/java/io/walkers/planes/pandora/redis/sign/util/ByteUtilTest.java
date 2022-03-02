package io.walkers.planes.pandora.redis.sign.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 字节工具类单元测试
 *
 * @author planeswalker23
 * @date 2022/2/26
 */
class ByteUtilTest {

    @Test
    void getBooleanArrayFromByte() {
        byte source0 = 0;
        boolean[] result0 = ByteUtil.getBooleanArrayFromByte(source0);
        Assertions.assertArrayEquals(new boolean[]{false, false, false, false, false, false, false, false}, result0);

        byte source1 = (byte) 255;
        boolean[] result1 = ByteUtil.getBooleanArrayFromByte(source1);
        Assertions.assertArrayEquals(new boolean[]{true, true, true, true, true, true, true, true}, result1);
    }

    @Test
    void getCharArrayFromByte() {
        byte source0 = 0;
        char[] result0 = ByteUtil.getCharArrayFromByte(source0);
        Assertions.assertArrayEquals(new char[]{'0', '0', '0', '0', '0', '0', '0', '0'}, result0);

        byte source1 = (byte) 255;
        char[] result1 = ByteUtil.getCharArrayFromByte(source1);
        Assertions.assertArrayEquals(new char[]{'1', '1', '1', '1', '1', '1', '1', '1'}, result1);
    }

    @Test
    void getStringFormByte() {
        byte source0 = 0;
        String result0 = ByteUtil.getStringFormByte(source0);
        Assertions.assertEquals("00000000", result0);

        byte source1 = (byte) 255;
        String result1 = ByteUtil.getStringFormByte(source1);
        Assertions.assertEquals("11111111", result1);
    }

    @Test
    void getStringFormByteArray() {
        byte[] sourceNull = null;
        String resultNull = ByteUtil.getStringFormByteArray(sourceNull);
        Assertions.assertEquals("00000000", resultNull);

        byte[] source0 = new byte[]{0, (byte) 255};
        String result0 = ByteUtil.getStringFormByteArray(source0);
        Assertions.assertEquals("0000000011111111", result0);

        byte[] source1 = new byte[]{(byte) 255, 0};
        String result1 = ByteUtil.getStringFormByteArray(source1);
        Assertions.assertEquals("1111111100000000", result1);
    }

    @Test
    void getByteFromBooleanArray() {
        boolean[] sourceNull = null;
        byte resultNull = ByteUtil.getByteFromBooleanArray(sourceNull);
        Assertions.assertEquals(0, resultNull);

        boolean[] source = new boolean[]{false, false, false, false, false, false, false, false};
        byte result = ByteUtil.getByteFromBooleanArray(source);
        Assertions.assertEquals(0, result);

        boolean[] source2 = new boolean[]{true, true, true, true, true, true, true, true};
        byte result2 = ByteUtil.getByteFromBooleanArray(source2);
        Assertions.assertEquals((byte) 255, result2);
    }
}