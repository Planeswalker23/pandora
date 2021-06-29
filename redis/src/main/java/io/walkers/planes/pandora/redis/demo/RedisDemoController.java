package io.walkers.planes.pandora.redis.demo;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * redis操作示例 {@link RedisTemplate}
 * @author Planeswalker23
 * @date Created in 2020/3/5
 */
@RestController
public class RedisDemoController {

    @Resource
    private UserOrderDetailCacheManager userOrderDetailCacheManager;
    @Resource
    private UserOrderCountInfoCacheManager userOrderCountInfoCacheManager;

    @GetMapping("/demo/add")
    public void add(Long userId, String status, Long orderId) {
        userOrderDetailCacheManager.put(1, userId, status, orderId);
        userOrderCountInfoCacheManager.putAndIncrement(1, userId, status);
    }

    @GetMapping("/demo/addSet")
    public void add(Long userId, String status) {
        Set<Long> set = new HashSet<>();
        set.add(90001L);
        set.add(90002L);
        set.add(90003L);
        userOrderDetailCacheManager.put(1, userId, status, set);
        userOrderCountInfoCacheManager.putAndIncrement(1, userId, status, Long.valueOf(set.size()));
    }

    @GetMapping("/demo/get")
    public Set<Long> get(Long userId, String status) {
        return userOrderDetailCacheManager.get(1, userId, status);
    }

    @GetMapping("/demo/deleteAll")
    public void deleteAll(Long userId, String status) {
        userOrderDetailCacheManager.delete(1, userId, status);
        userOrderCountInfoCacheManager.delete(1, userId);

    }

    @GetMapping("/demo/delete")
    public void delete(Long userId, String status, Long orderId) {
        userOrderDetailCacheManager.delete(1, userId, status, orderId);
        userOrderCountInfoCacheManager.putAndDecrement(1, userId, status);
    }
}
