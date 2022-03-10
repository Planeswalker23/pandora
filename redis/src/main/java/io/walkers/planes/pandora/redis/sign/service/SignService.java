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
        // 获取日期偏移量，因为位图从0开始，所以需要做-1操作
        long offset = DateUtil.getDayOfYear() - 1;
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
    public String buildBitmapKey(String userId) {
        String key = String.format("sign:%s:%s", userId, LocalDateTime.now().getYear());
        log.info("Redis Bitmap key of userId {} is {}.", userId, key);
        return key;
    }

    /**
     * 获取累计签到天数
     *
     * @param userId 用户ID
     * @return Long
     */
    public Long getTotalSignDays(String userId) {
        // 构建Redis键
        String key = this.buildBitmapKey(userId);
        // 获取位图中二进制位值为1的总数
        Long result = bitmapUtil.bitCountTrue(key);
        log.info("User which id is {} has {} days signed.", userId, result);
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
        long weekFirstDayOfYear = DateUtil.getWeekFirstDayOfYear();
        // 获取本周的签到记录
        String weekSignRecord = signRecord.substring((int) weekFirstDayOfYear, (int) weekFirstDayOfYear + 7);
        log.info("User which id is {}, week sign record is {}.", userId, weekSignRecord);
        return weekSignRecord;
    }

    /**
     * 获取本月签到记录
     *
     * @param userId 用户ID
     * @return String 二进制0-1字符串
     */
    public String getSignRecordOfThisMonth(String userId) {
        // 构建Redis键
        String key = this.buildBitmapKey(userId);
        // 获取整个签到记录
        String signRecord = bitmapUtil.getBitString(key);
        // 获取本月1号的日期偏移量
        long monthFirstDayOfYear = DateUtil.getMonthFirstDayOfYear();
        // 填充缺失的后置二进制0值，防止字符串长度不够
        // TODO 可以使用更高效的方法
        long monthLastDayOfYear = (int) monthFirstDayOfYear + LocalDateTime.now().getMonth().maxLength();
        if (signRecord.length() < monthLastDayOfYear) {
            StringBuilder zero = new StringBuilder();
            for (int i = 0; i < monthLastDayOfYear - signRecord.length(); i++) {
                zero.append("0");
            }
            signRecord = signRecord + zero;
        }
        // 获取本周的签到记录
        String weekSignRecord = signRecord.substring((int) monthFirstDayOfYear, (int) monthFirstDayOfYear + LocalDateTime.now().getMonth().maxLength());
        log.info("User which id is {}, month sign record is {}.", userId, weekSignRecord);
        return weekSignRecord;
    }

    /**
     * 获取连续签到天数
     *
     * @param userId 用户ID
     * @return Long
     */
    public Long getContinuousSignDays(String userId) {
        // 构建Redis键
        String key = this.buildBitmapKey(userId);
        // 获取日期偏移量
        long dayOfYear = DateUtil.getDayOfYear();
        // 获取整个签到记录
        String signRecord = bitmapUtil.getBitString2(0L, dayOfYear, key);
        // 截取到当天的签到记录
        signRecord = signRecord.substring(0, (int) dayOfYear);
        char[] array = signRecord.toCharArray();
        // 当天已签到可累计，当天未签到也不算断签
        Long result = array[signRecord.length() - 1] == '1' ? 1L : 0L;
        for (int i = signRecord.length() - 2; i > 0; i--) {
            if (array[i] == '1') {
                result++;
            } else {
                break;
            }
        }
        log.info("User which id is {}, continuous sSign days is {}.", userId, result);
        return result;
    }
}
