package io.walkers.planes.pandora.redis.lock.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * redis服务层
 * @author Planeswalker23
 * @date Created in 2020/11/18
 */
@Slf4j
@Service
public class RedisService {

    public static final String ServerSingle = "WindFall-Main";

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 分布式锁 加锁 version1
     * @param redisKey 键
     * @param redisValue 值
     * @return boolean
     */
    public boolean lock1(String redisKey, String redisValue) {
        if (Boolean.TRUE.equals(redisTemplate.opsForValue().setIfAbsent(redisKey, redisValue))) {
            log.info("Distributed Lock version 1 locking success, key-[{}], value-[{}]", redisKey, redisValue);
            return true;
        }
        log.info("Distributed Lock version 1 locking failed, key existed, key-[{}], value-[{}]", redisKey, redisValue);
        return false;
    }

    /**
     * 分布式锁 加锁 version2 - 解决分布式死锁问题
     * @param redisKey 键
     * @param redisValue 值
     * @param expireTime 过期时间
     * @param timeUnit 时间单位
     * @return boolean
     */
    public boolean lock2(String redisKey, String redisValue, long expireTime, TimeUnit timeUnit) {
        if (Boolean.TRUE.equals(redisTemplate.opsForValue().setIfAbsent(redisKey, redisValue, expireTime, timeUnit))) {
            log.info("Distributed Lock version 2 locking success, key-[{}], value-[{}]", redisKey, redisValue);
            return true;
        }
        log.info("Distributed Lock version 2 locking failed, key existed, key-[{}], value-[{}]", redisKey, redisValue);
        return false;
    }

    /**
     * 分布式锁 加锁 version3 - 解决自动解锁问题（业务事务时长大于过期时间的情况，通过自动续期来解决，所以需要把锁设置为可重入锁）
     * @param redisKey 键
     * @param redisValue 值 （过期时间戳）
     * @param expireTime 过期时间
     * @param timeUnit 时间单位
     * @return boolean
     */
    public boolean lock3(String redisKey, String redisValue, long expireTime, TimeUnit timeUnit) {
        if (Boolean.TRUE.equals(redisTemplate.opsForValue().setIfAbsent(redisKey, redisValue, expireTime, timeUnit))) {
            log.info("Distributed Lock version 3 locking success, key-[{}], value-[{}]", redisKey, redisValue);
            return true;
        }
        String valueInRedis = redisTemplate.opsForValue().get(redisKey);
        // fix: 无法区分不同客户端操作的问题（Redis value中附带客户端标识）
        if (!this.isLocalConsumer(valueInRedis)) {
            return false;
        }
        valueInRedis = valueInRedis.replace(ServerSingle, "");
        long expiredTimeInValue = Long.parseLong(valueInRedis);
        // 未过期且为加锁方标识一致，设置为可重入锁，同时更新过期时间
        // 使用 setIfPresent 来避免锁过期
        if (Boolean.TRUE.equals(redisTemplate.opsForValue().setIfPresent(redisKey, ServerSingle+redisValue, expireTime, timeUnit))) {
            log.info("Distributed Lock version 3 locking success, key existed but update its expired time, key-[{}], value-[{}]", redisKey, redisValue);
            return true;
        }
        log.info("Distributed Lock version 3 locking failed, key existed, key-[{}], value-[{}]", redisKey, redisValue);
        return false;
    }

    /**
     * 分布式锁，解锁 - version1
     * @param redisKey
     * @return
     */
    public boolean unlock1(String redisKey) {
        String redisValue = redisTemplate.opsForValue().get(redisKey);
        if (ObjectUtils.isEmpty(redisValue)) {
            log.info("Distributed Lock unlock failed, key not exist or key is expired, key-[{}], unlocked by-[{}]", redisKey, ServerSingle);
            return false;
        }
        // fix: 无法区分不同客户端操作的问题（Redis value中附带客户端标识）
        if (!this.isLocalConsumer(redisValue)) {
            return false;
        }
        if (Boolean.TRUE.equals(redisTemplate.opsForValue().getOperations().delete(redisKey))) {
            log.info("Distributed Lock unlock success, key-[{}], unlocked by-[{}]", redisKey, ServerSingle);
            return true;
        }
        log.info("Distributed Lock unlock failed, key not exist or key is expired, key-[{}], unlocked by-[{}]", redisKey, ServerSingle);
        return false;
    }

    /**
     * 判断值是否为本客户端设置的
     * @param valueInRedis
     * @return boolean
     */
    private boolean isLocalConsumer(String valueInRedis) {
        // fix: 无法区分不同客户端操作的问题（Redis value中附带客户端标识）
        if (valueInRedis==null || !valueInRedis.contains(ServerSingle)) {
            log.info("Distributed Lock does not exist or not lock by this server, value-[{}]", valueInRedis);
            return false;
        }
        return true;
    }
}
