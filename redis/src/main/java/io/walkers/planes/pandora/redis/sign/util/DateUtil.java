package io.walkers.planes.pandora.redis.sign.util;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * 日期工具类
 *
 * @author 范逸东(东稚)
 */
@Slf4j
public class DateUtil {

    /**
     * 获取当天与1月1日的偏移量
     *
     * @return long 偏移量
     */
    public static long getDayOfYear() {
        return getDayOfYear(null, null, null);
    }

    /**
     * 获取指定日期与1月1日的偏移量
     *
     * @param year  年份
     * @param month 月份
     * @param day   日期
     * @return long 偏移量
     */
    public static long getDayOfYear(Integer year, Integer month, Integer day) {
        LocalDateTime localDateTime;
        if (year == null) {
            localDateTime = LocalDateTime.now();
        } else {
            localDateTime = LocalDateTime.of(year, month, day, 0, 0);
        }
        int dayOfYear = localDateTime.getDayOfYear();
        log.info("Today is {}/{}/{},  No.{} of this year.", localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth(), dayOfYear);
        return dayOfYear;
    }

    /**
     * 获取本周一与1月1日的偏移量
     *
     * @return long
     */
    public static long getWeekFirstDayOfYear() {
        LocalDateTime today = LocalDateTime.now();
        long dayOfYear = getDayOfYear();
        int dayOfWeek = today.getDayOfWeek().getValue();
        // 计算周一的偏移量
        long result = dayOfYear - dayOfWeek;
        log.info("WeekFirstDay is {}/{}/{}, No.{} of this year.", today.getYear(), today.getMonthValue(), today.getDayOfMonth() - dayOfWeek, result);
        return result;
    }

    /**
     * 获取本月1号与1月1日的偏移量
     *
     * @return long
     */
    public static long getMonthFirstDayOfYear() {
        LocalDateTime today = LocalDateTime.now();
        long dayOfYear = getDayOfYear();
        int dayOfMonth = today.getDayOfMonth();
        // 计算本月1号的偏移量
        long result = dayOfYear - dayOfMonth;
        log.info("MonthFirstDay is {}/{}/{}, is No.{} of this year.", today.getYear(), today.getMonthValue(), today.getDayOfMonth() + dayOfMonth, result);
        return result;
    }
}
