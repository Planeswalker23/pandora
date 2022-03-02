package io.walkers.planes.pandora.redis.sign.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author planeswalker23
 * @date 2022/3/2
 */
@SpringBootTest
public class BitmapUtilTest {

    @Autowired
    private BitmapUtil bitmapUtil;

    private final String key = "key";

    @Test
    public void coreMethod() {
        // 01100001
        String a = "a";
        bitmapUtil.set(key, a);
        String result = bitmapUtil.get(key);
        Assertions.assertEquals(a, result);

        // SETBIT 0 0 : 0
        Boolean setBitResult = bitmapUtil.setBit(key, 0L, false);
        Assertions.assertEquals(Boolean.FALSE, setBitResult);

        // GETBIT 0 2 : 1
        Boolean getBitResult = bitmapUtil.getBit(key, 2L);
        Assertions.assertEquals(Boolean.TRUE, getBitResult);

        // BITCOUNT key : 3
        Long countResult1 = bitmapUtil.bitCountTrue(key);
        Assertions.assertEquals(3L, countResult1);
        // BITCOUNT key 0 1 : 3
        Long countResult2 = bitmapUtil.bitCountTrue(key, 0L, 1L);
        Assertions.assertEquals(3L, countResult2);
        // BITCOUNT key 1 2 : 0
        Long countResult3 = bitmapUtil.bitCountTrue(key, 1L, 2L);
        Assertions.assertEquals(0L, countResult3);

        // BITPOS key 1 : 1
        Long countPos1Result = bitmapUtil.bitPos(key, true);
        Assertions.assertEquals(1L, countPos1Result);

        // BITPOS key 1 0 1: 1
        Long countPos0Result = bitmapUtil.bitPos(key, true, 0L, 1L);
        Assertions.assertEquals(1L, countPos0Result);

        // BITPOS key 1 1 2: -1
        Long countPos0Result2 = bitmapUtil.bitPos(key, true, 1L, 2L);
        Assertions.assertEquals(-1L, countPos0Result2);

        // bit to byte to String
        String bitString = bitmapUtil.getBitString(key);
        Assertions.assertEquals("01100001", bitString);
    }
}
