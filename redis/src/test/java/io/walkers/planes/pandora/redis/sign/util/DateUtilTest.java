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
        // 1.1 -> 1
        long dayOfYear0 = DateUtil.getDayOfYear(2022, 1, 1);
        Assertions.assertEquals(1, dayOfYear0);

        // 2.1 -> 32
        long dayOfYear31 = DateUtil.getDayOfYear(2022, 2, 1);
        Assertions.assertEquals(32, dayOfYear31);

        // 3.9 -> 68
        long dayOfYear67 = DateUtil.getDayOfYear(2022, 3, 9);
        Assertions.assertEquals(68, dayOfYear67);

        // today
        long dayOfYear = DateUtil.getDayOfYear();
        Assertions.assertEquals(LocalDateTime.now().getDayOfYear(), dayOfYear);
    }

    @Test
    void getWeekFirstDayOfYear() {
        long weekFirstDayOfYear = DateUtil.getWeekFirstDayOfYear();
        long dayOfYear = DateUtil.getDayOfYear();
        int value = LocalDateTime.now().getDayOfWeek().getValue();
        Assertions.assertEquals(weekFirstDayOfYear, dayOfYear - value);
    }

    @Test
    void getMonthFirstDayOfYear() {
        long monthFirstDayOfYear = DateUtil.getMonthFirstDayOfYear();
        long dayOfYear = DateUtil.getDayOfYear();
        int value = LocalDateTime.now().getDayOfMonth();
        Assertions.assertEquals(monthFirstDayOfYear, dayOfYear - value);
    }
}