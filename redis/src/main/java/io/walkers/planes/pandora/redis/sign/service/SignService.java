package io.walkers.planes.pandora.redis.sign.service;

import io.walkers.planes.pandora.redis.sign.util.BitmapUtil;
import io.walkers.planes.pandora.redis.sign.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author 范逸东(东稚)
 */
@Slf4j
@Service
public class SignService {

    @Autowired
    private BitmapUtil bitmapUtil;

    /**
     * 签到方法
     *
     * @param userId 用户ID
     * @return Boolean
     */
    public Boolean sign(String userId) {
        // 构建Redis键
        String key = this.buildBitmapKey(userId);
        // 获取日期偏移量
        long offset = DateUtil.getDayOfYear();
        // 签到业务
        Boolean formerSignResult = bitmapUtil.setBit(key, offset, true);
        // 重复签到校验
        if (Boolean.TRUE.equals(formerSignResult)) {
            throw new RuntimeException("签到失败：今天已经签到过了！");
        }
        return Boolean.TRUE;
    }

    /**
     * 构建 Bitmap 键: sign:userId:year
     *
     * @param userId 用户ID
     * @return String
     */
    private String buildBitmapKey(String userId) {
        String key = String.format("sign:%s:%s", userId, LocalDateTime.now().getYear());
        log.info("Redis Bitmap key of userId {} is {}", userId, key);
        return key;
    }

    /**
     * 计算累计签到天数
     *
     * @param userId 用户ID
     * @return Long
     */
    public Long getTotalSignDays(String userId) {
        // 构建Redis键
        String key = this.buildBitmapKey(userId);
        // 获取位图中二进制位值为1的总数
        Long result = bitmapUtil.bitCountTrue(key);
        log.info("User which id is {} has {} days signed", userId, result);
        return result;
    }

    /**
     * 获取本周签到记录
     *
     * @param userId 用户ID
     * @return String 二进制0-1字符串
     */
    public String getSignRecordOfThisWeek(String userId) {
        // 构建Redis键
        String key = this.buildBitmapKey(userId);
        // 获取整个签到记录
        String signRecord = bitmapUtil.getBitString(key);
        // 获取本周一的日期偏移量
        long weekFistDayOfYear = DateUtil.getWeekFirstDayOfYear();
        // 获取本周的签到记录
        String weekSignRecord = signRecord.substring((int) weekFistDayOfYear, (int) weekFistDayOfYear + 7);
        log.info("User which id is {}, sign record is {}", userId, weekSignRecord);
        return weekSignRecord;
    }
}
