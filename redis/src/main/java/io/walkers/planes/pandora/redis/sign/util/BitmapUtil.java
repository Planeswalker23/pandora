package io.walkers.planes.pandora.redis.sign.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 位图工具类
 *
 * @author planeswalker23
 * @date 2022/2/26
 */
@Slf4j
@Component
public class BitmapUtil {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 根据key获取值
     *
     * @param key 键
     * @return String
     */
    public String get(String key) {
        String result = redisTemplate.opsForValue().get(key);
        log.info("Bitmap GET operation successfully. Result following: key is {{}}, value is {{}}.", key, result);
        return result;
    }

    /**
     * 为key设置值
     *
     * @param key   键
     * @param value 值
     */
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
        log.info("Bitmap SET operation successfully. Result following: key is {{}}, value is {{}}.", key, value);
    }

    /**
     * 对位图中某一二进制位进行赋值
     *
     * @param key    键
     * @param offset 偏移量，二进制位
     * @param value  值
     * @return Boolean 该位置上原来的值
     */
    public Boolean setBit(String key, long offset, boolean value) {
        Boolean result = redisTemplate.opsForValue().setBit(key, offset, value);
        log.info("Bitmap SETBIT operation successfully. Result following: key is {{}}, offset is {{}}, value is {{}}. Former value is {{}}", key, offset, value, result);
        return result;
    }

    /**
     * 获取位图中某一指定偏移量的二进制值
     *
     * @param key    键
     * @param offset 偏移量，二进制位
     * @return Boolean
     */
    public Boolean getBit(String key, long offset) {
        Boolean result = redisTemplate.opsForValue().getBit(key, offset);
        log.info("Bitmap GETBIT operation successfully. Result following: key is {{}}, offset is {{}}, value is {{}}.", key, offset, result);
        return result;
    }


    /**
     * 统计位图值对应位为1的数量
     *
     * @param key 键
     * @return Long
     */
    public Long bitCountTrue(String key) {
        Long result = redisTemplate.execute((RedisCallback<Long>) con -> con.bitCount(key.getBytes()));
        log.info("Bitmap BITCOUNT operation successfully. Result following: key is {{}}, result is {{}}.", key, result);
        return result;
    }

    /**
     * 统计位图值指定范围（范围为字节范围）对应位为1的数量
     *
     * @param key   键
     * @param start 开始字节位置（包含）
     * @param end   结束字节位置（包含）
     * @return Long
     */
    public Long bitCountTrue(String key, long start, long end) {
        Long result = redisTemplate.execute((RedisCallback<Long>) con -> con.bitCount(key.getBytes(), start, end));
        log.info("Bitmap BITCOUNT operation successfully. Result following: key is {{}}, result is {{}}, startByteIndex is {}, endByteIndex is {}.", key, result, start, end);
        return result;
    }


    /**
     * 统计位图值指定二进制值的数量
     *
     * @param key   键
     * @param value 指定二进制值
     * @return Long
     */
    public Long bitPos(String key, boolean value) {
        Long result = redisTemplate.execute((RedisCallback<Long>) con -> con.bitPos(key.getBytes(), value));
        log.info("Bitmap BITPOS operation successfully. Result following: key is {{}}, value is {{}}, result is {{}}.", key, value, result);
        return result;
    }


    /**
     * 统计位图值指定范围（范围为字节范围）指定二进制值的数量
     *
     * @param key   键
     * @param value 指定二进制值
     * @param start 开始字节位置（包含）
     * @param end   结束字节位置（包含）
     * @return Long
     */
    public Long bitPos(String key, boolean value, long start, long end) {
        Long result = redisTemplate.execute((RedisCallback<Long>) con -> con.bitPos(key.getBytes(), value, Range.open(start, end)));
        log.info("Bitmap BITPOS operation successfully. Result following: key is {{}}, value is {{}}, result is {{}}, startByteIndex is {}, endByteIndex is {}.", key, value, result, start, end);
        return result;
    }

    /**
     * 根据key获取整个位图的值，并转化为8位 0-1 String
     *
     * @param key 键
     * @return String
     */
    public String getBitString(String key) {
        String redisResult = redisTemplate.opsForValue().get(key);
        byte[] byteResult = redisResult == null ? null : redisResult.getBytes();
        String result = ByteUtil.getStringFormByteArray(byteResult);
        log.info("Bitmap GET operation successfully. Result following: key is {{}}, value is {{}}.", key, result);
        return result;
    }

    public String getBitString2(Long days, String key) {
        long start = System.currentTimeMillis();
        // 拼接返回结果
        StringBuilder result = new StringBuilder();
        for (long offset = 0; offset < days; offset++) {
            // 获取指定偏移位上的二进制值
            Boolean booleanResult = redisTemplate.opsForValue().getBit(key, offset);
            // 进行字符串0-1赋值
            result.append(Boolean.TRUE.equals(booleanResult) ? "1" : "0");
        }
        log.info("Version1 cost: {}", System.currentTimeMillis() - start);
        return result.toString();
    }

    public String getBitString2(String key) {
        long start = System.currentTimeMillis();
        // 获取 Redis 中对应 KEY 的值
        String redisResult = redisTemplate.opsForValue().get(key);
        // 将字符串转化为字节数组
        byte[] byteResult = redisResult == null ? new byte[0] : redisResult.getBytes();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < byteResult.length; i++) {
            byte sourceByte = byteResult[i];
            // 将字节数组中每一位转化为二进制
            char[] charArray = new char[8];
            for (int j = 7; j >= 0; j--) {
                // 判定byte的最后一位是否为1，若为1，则是true；否则是false
                charArray[j] = (sourceByte & 1) == 1 ? '1' : '0';
                // byte右移一位
                sourceByte = (byte) (sourceByte >> 1);
            }
            // 将转化结果二进制字符数组拼接到返回结果中
            result.append(charArray);
        }
        log.info("Version1 cost: {}", System.currentTimeMillis() - start);
        return result.toString();
    }
}
