package io.walkers.planes.pandora.redis.sign.service;

import io.walkers.planes.pandora.redis.sign.util.BitmapUtil;
import io.walkers.planes.pandora.redis.sign.util.DateUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

/**
 * 签到 Service 单元测试
 *
 * @author planeswalker23
 * @date 2022/3/9
 */
@SpringBootTest
public class SignServiceTest {

    private final String userId = "1";
    @Autowired
    private BitmapUtil bitmapUtil;
    @Autowired
    private SignService signService;

    @Test
    public void sign() {
        String bitmapKey = signService.buildBitmapKey(userId);
        bitmapUtil.delete(bitmapKey);

        // 签到
        Boolean sign = signService.sign(userId);
        Assertions.assertTrue(sign);

        // 重复签到
        try {
            signService.sign(userId);
        } catch (RuntimeException e) {
            Assertions.assertEquals("签到失败：今天已经签到过了！", e.getMessage());
        }

        // 获取累计签到天数
        Long totalSignDays = signService.getTotalSignDays(userId);
        Assertions.assertEquals(1L, totalSignDays);

        // 获取本周签到记录
        String signRecordOfThisWeek = signService.getSignRecordOfThisWeek(userId);
        int dayOfWeek = LocalDateTime.now().getDayOfWeek().getValue();
        StringBuilder weekSignRecordBuilder = new StringBuilder();
        for (int i = 1; i <= 7; i++) {
            if (i == dayOfWeek) {
                weekSignRecordBuilder.append("1");
            } else {
                weekSignRecordBuilder.append("0");
            }

        }
        Assertions.assertEquals(weekSignRecordBuilder.toString(), signRecordOfThisWeek);

        // 获取本月签到记录
        String signRecordOfThisMonth = signService.getSignRecordOfThisMonth(userId);
        int monthLength = LocalDateTime.now().getMonth().maxLength();
        int dayOfMonth = LocalDateTime.now().getDayOfMonth();
        StringBuilder monthSignRecordBuilder = new StringBuilder();
        for (int i = 1; i <= monthLength; i++) {
            if (i == dayOfMonth) {
                monthSignRecordBuilder.append("1");
            } else {
                monthSignRecordBuilder.append("0");
            }
        }
        Assertions.assertEquals(monthSignRecordBuilder.toString(), signRecordOfThisMonth);
    }


    @Test
    public void getContinuousSignDays() {
        String bitmapKey = signService.buildBitmapKey(userId);
        bitmapUtil.delete(bitmapKey);

        // 连续签到天数
        System.out.println("第一次获取连续签到天数");
        Long continuousSignDays = signService.getContinuousSignDays(userId);
        Assertions.assertEquals(0L, continuousSignDays);

        long today = DateUtil.getDayOfYear();
        // 昨天签到
        System.out.println("昨天签到");
        bitmapUtil.setBit(bitmapKey, today - 2, true);
        System.out.println("第二次获取连续签到天数");
        Long continuousSignDays1 = signService.getContinuousSignDays(userId);
        Assertions.assertEquals(1L, continuousSignDays1);

        // 六天前签到
        System.out.println("六天前签到");
        bitmapUtil.setBit(bitmapKey, today - 7, true);
        System.out.println("第三次获取连续签到天数");
        Long continuousSignDays3 = signService.getContinuousSignDays(userId);
        Assertions.assertEquals(1L, continuousSignDays3);

        // 今天签到
        System.out.println("今天签到");
        bitmapUtil.setBit(bitmapKey, today - 1, true);
        System.out.println("第四次获取连续签到天数");
        Long continuousSignDays2 = signService.getContinuousSignDays(userId);
        Assertions.assertEquals(2L, continuousSignDays2);
    }
}
