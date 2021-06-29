package io.walkers.planes.pandora.redis.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Set;

/**
 * 用户订单详情缓存管理类(Redis DataStructure: Zset)
 * key: user-order-detail-cache:tenantId:buyerId:FrontOrderStatus
 * value: Set<Long>(用户订单详情)
 *
 * @author planeswalker23
 * @date 2021/05/19
 */
@Slf4j
@Repository
public class UserOrderDetailCacheManager {

    /**
     * 缓存前缀 KEY
     */
    private final String PREFIX_USER_ORDER_DETAIL = "user-order-detail-cache";
    @Resource
    private RedisTemplate<String, Long> redisTemplate;

    /**
     * 存放缓存数据 Set
     *
     * @param tenantId         租户ID
     * @param buyerId          用户ID
     * @param frontOrderStatus 订单展示状态
     * @param valueSet         值
     */
    public void put(Integer tenantId, Long buyerId, String frontOrderStatus, Set<Long> valueSet) {
        final String key = generateCacheKey(tenantId, buyerId, frontOrderStatus);
        for (Long value : valueSet) {
            redisTemplate.opsForSet().add(key, value);
        }
        log.info("put user order detail from redis cache, key = {}, value = {}", key, valueSet);
    }

    /**
     * 存放缓存数据 Long
     *
     * @param tenantId         租户ID
     * @param buyerId          用户ID
     * @param frontOrderStatus 订单展示状态
     * @param value            值
     */
    public void put(Integer tenantId, Long buyerId, String frontOrderStatus, Long value) {
        final String key = generateCacheKey(tenantId, buyerId, frontOrderStatus);
        redisTemplate.opsForSet().add(key, value);
        log.info("add single value into user order detail from redis cache, key = {}, value = {} ", key, value);
    }

    /**
     * 获取缓存数据
     *
     * @param tenantId         租户ID
     * @param buyerId          用户ID
     * @param frontOrderStatus 订单展示状态
     * @return 订单状态统计信息
     */
    public Set<Long> get(Integer tenantId, Long buyerId, String frontOrderStatus) {
        final String key = generateCacheKey(tenantId, buyerId, frontOrderStatus);
        Set<Long> set = redisTemplate.opsForSet().members(key);
        log.info("get user order detail from redis cache, key = {}, result = {}", key, set);
        return set;
    }

    /**
     * 删除缓存
     *
     * @param tenantId         租户ID
     * @param buyerId          用户ID
     * @param frontOrderStatus 订单展示状态
     */
    public void delete(Integer tenantId, Long buyerId, String frontOrderStatus) {
        final String key = generateCacheKey(tenantId, buyerId, frontOrderStatus);
        redisTemplate.delete(key);
        log.info("delete user order detail from redis cache, key = {}", key);
    }

    /**
     * 删除缓存 single set value
     *
     * @param tenantId         租户ID
     * @param buyerId          用户ID
     * @param frontOrderStatus 订单展示状态
     */
    public void delete(Integer tenantId, Long buyerId, String frontOrderStatus, Long valueInSet) {
        final String key = generateCacheKey(tenantId, buyerId, frontOrderStatus);
        redisTemplate.opsForSet().remove(key, valueInSet);
        log.info("delete single value of user order detail from redis cache, key = {}, value={}", key, valueInSet);
    }

    /**
     * 组装缓存中的键
     *
     * @param tenantId         租户ID
     * @param buyerId          用户ID
     * @param frontOrderStatus 订单展示状态
     * @return 键
     */
    public String generateCacheKey(Integer tenantId, Long buyerId, String frontOrderStatus) {
        return String.join(":", PREFIX_USER_ORDER_DETAIL, frontOrderStatus, String.valueOf(tenantId), String.valueOf(buyerId));
    }
}
