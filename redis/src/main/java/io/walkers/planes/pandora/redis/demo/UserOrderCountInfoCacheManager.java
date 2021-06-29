package io.walkers.planes.pandora.redis.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 用户订单统计信息缓存管理类(Redis DataStructure: Hash)
 * key: user-order-detail-cache:tenantId:buyerId
 * value: Map<String, Long>(用户订单统计信息)
 *
 * @author planeswalker23
 * @date 2021/05/19
 */
@Slf4j
@Repository
public class UserOrderCountInfoCacheManager {

    /**
     * 缓存前缀 KEY
     */
    private final String PREFIX_USER_ORDER_COUNT_INFO = "user-order-count-info-data-cache";
    @Resource
    private RedisTemplate<String, Map<String, Long>> redisTemplate;

    /**
     * 存放缓存数据 Map
     *
     * @param tenantId 租户ID
     * @param buyerId  用户ID
     * @param map      值
     */
    public void put(Integer tenantId, Long buyerId, Map<String, Long> map) {
        final String key = generateCacheKey(tenantId, buyerId);
        redisTemplate.opsForHash().putAll(key, map);
        log.info("put user order count info from redis cache, key = {}, value = {}", key, map);
    }

    /**
     * 存放缓存数据 Long
     *
     * @param tenantId  租户ID
     * @param buyerId   用户ID
     * @param hashKey   hash key
     * @param hashValue 值
     */
    public void put(Integer tenantId, Long buyerId, String hashKey, Long hashValue) {
        final String key = generateCacheKey(tenantId, buyerId);
        redisTemplate.opsForHash().put(key, hashKey, hashValue);
        log.info("add single value into user order count info from redis cache, key = {}, hashKey = {}, hashValue = {} ", key, hashKey, hashValue);
    }

    /**
     * 存放缓存数据 Long 自增+1
     *
     * @param tenantId  租户ID
     * @param buyerId   用户ID
     * @param hashKey   hash key
     */
    public void putAndIncrement(Integer tenantId, Long buyerId, String hashKey) {
        final String key = generateCacheKey(tenantId, buyerId);
        redisTemplate.opsForHash().increment(key, hashKey, 1L);
        log.info("putAndIncrement user order count info from redis cache, key = {}, hashKey = {}, increment = {}", key, hashKey, 1L);
    }

    /**
     * 存放缓存数据 Long 自增+n
     *
     * @param tenantId  租户ID
     * @param buyerId   用户ID
     * @param hashKey   hash key
     */
    public void putAndIncrement(Integer tenantId, Long buyerId, String hashKey, Long increment) {
        final String key = generateCacheKey(tenantId, buyerId);
        redisTemplate.opsForHash().increment(key, hashKey, increment);
        log.info("putAndIncrement user order count info from redis cache, key = {}, hashKey = {}, increment = {}", key, hashKey, increment);
    }

    /**
     * 存放缓存数据 Long 自增-1
     *
     * @param tenantId  租户ID
     * @param buyerId   用户ID
     * @param hashKey   hash key
     */
    public void putAndDecrement(Integer tenantId, Long buyerId, String hashKey) {
        final String key = generateCacheKey(tenantId, buyerId);
        redisTemplate.opsForHash().increment(key, hashKey, -1L);
        log.info("putAndDecrement user order count info from redis cache, key = {}, hashKey = {}", key, hashKey);
    }

    /**
     * 获取缓存数据
     *
     * @param tenantId 租户ID
     * @param buyerId  用户ID
     * @return 订单状态统计信息
     */
    public Map<Object, Object> get(Integer tenantId, Long buyerId) {
        final String key = generateCacheKey(tenantId, buyerId);
        // at least entries 's result is a Collections.emptyMap()
        Map<Object, Object> map = redisTemplate.opsForHash().entries(key);

        return map;
    }

    /**
     * 获取缓存数据
     *
     * @param tenantId 租户ID
     * @param buyerId  用户ID
     * @return 订单状态统计信息
     */
//    public List<OrderStatusCountInfo> getAndConvertOrderStatusCountInfos(Integer tenantId, Long buyerId) {
//        Map<Object, Object> map = this.get(tenantId, buyerId);
//        List<OrderStatusCountInfo> list = Lists.newArrayListWithExpectedSize(map.size());
//        return list;
//    }

    /**
     * 删除缓存
     *
     * @param tenantId 租户ID
     * @param buyerId  用户ID
     */
    public void delete(Integer tenantId, Long buyerId) {
        final String key = generateCacheKey(tenantId, buyerId);
        redisTemplate.delete(key);
        log.info("delete user order count info from redis cache, key = {}", key);
    }

    /**
     * 删除缓存 hashKey
     *
     * @param tenantId 租户ID
     * @param buyerId  用户ID
     * @param hashKey  哈希键
     */
    public void delete(Integer tenantId, Long buyerId, String hashKey) {
        final String key = generateCacheKey(tenantId, buyerId);
        redisTemplate.opsForHash().delete(key, hashKey);
        log.info("delete hashKey of user order count info from redis cache, key = {}, hashKey = {}", key, hashKey);
    }

    /**
     * 组装缓存中的键
     *
     * @param tenantId 租户ID
     * @param buyerId  用户ID
     * @return 键
     */
    public String generateCacheKey(Integer tenantId, Long buyerId) {
        return String.join(":", PREFIX_USER_ORDER_COUNT_INFO, String.valueOf(tenantId), String.valueOf(buyerId));
    }
}
