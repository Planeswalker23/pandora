package io.walkers.planes.pandora.redis.sign.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

/**
 * 日期工具类单元测试
 *
 * @author planeswalker23
 * @date 2022/3/9
 */
public class DateUtilTest {

    @Test
    void getDayOfYear() {
        // 1.1 -> 0
        long dayOfYear0 = DateUtil.getDayOfYear(2022, 1, 1);
        Assertions.assertEquals(0, dayOfYear0);

        // 2.1 -> 31
        long dayOfYear31 = DateUtil.getDayOfYear(2022, 2, 1);
        Assertions.assertEquals(31, dayOfYear31);

        // 3.9 -> 67
        long dayOfYear67 = DateUtil.getDayOfYear(2022, 3, 9);
        Assertions.assertEquals(67, dayOfYear67);

        // today -> 67
        long dayOfYear = DateUtil.getDayOfYear();
        Assertions.assertEquals(LocalDateTime.now().getDayOfYear() - 1, dayOfYear);
    }

    @Test
    void getWeekFirstDayOfYear() {
        long weekFirstDayOfYear = DateUtil.getWeekFirstDayOfYear();
        long dayOfYear = DateUtil.getDayOfYear();
        int value = LocalDateTime.now().getDayOfWeek().getValue();
        Assertions.assertEquals(weekFirstDayOfYear, dayOfYear - value + 1);
    }
}