package io.walkers.planes.pandora.redis.lock.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.walkers.planes.pandora.redis.lock.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * redis操作示例 {@link RedisTemplate}
 * @author Planeswalker23
 * @date Created in 2020/3/5
 */
@RestController
public class RedisController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private RedisService redisService;

    @GetMapping("/redis/getValueFromRedis")
    public String getValueFromRedis(String id) throws JsonProcessingException {
        // 从redis缓存中获得指定的数据
        String userString = redisTemplate.boundValueOps(id).get();
        //如果redis中没有数据的话
        if (StringUtils.isEmpty(userString)) {
            //查询数据库获得数据
            List<User> users = jdbcTemplate.query("select * from user where id=?", new Object[]{id}, new BeanPropertyRowMapper(User.class));
            //转换成json格式字符串
            ObjectMapper om = new ObjectMapper();
            userString = om.writeValueAsString(users);
            //将数据存储到redis中，下次在查询直接从redis中获得数据，不用在查询数据库
            redisTemplate.boundValueOps(id).set(userString);
            System.out.println("===============从数据库获得数据===============");
        } else {
            System.out.println("===============从redis缓存中获得数据===============");
        }
        System.out.println(userString);
        return userString;
    }

    /**
     * http://127.0.0.1:8080/redis/lock?key=fanyidong&value=lock&version=3
     * @param version
     * @param key
     * @param value
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/redis/lock")
    public Object lock(int version, String key, String value) throws InterruptedException {
        boolean islock = false;
        long now = System.currentTimeMillis();
        if (version==1) {
            // 存在分布式死锁问题
            islock = redisService.lock1(key, value);
        } else if (version==2) {
            // 存在自动解锁问题 && 存在无法区分不同客户端操作的问题
            // todo 通过 Redission 的 wtach dog 为分布式锁自动续期，定时监控此key，若依旧被该客户端持有，更新过期时间
            islock = redisService.lock2(key, RedisService.ServerSingle + now + 10000, 10, TimeUnit.SECONDS);
        } else if (version==3) {
            // 存在自动解锁问题
            islock = redisService.lock3(key, RedisService.ServerSingle + now + 10000, 10, TimeUnit.SECONDS);
        }
        // 加锁成功
        if (!islock) {
            return false;
        }
        // 处理业务大于过期时间
//        TimeUnit.SECONDS.sleep(11);
        // 解锁
        return redisService.unlock1(key);
    }

    /**
     * 测试可重入锁
     * http://127.0.0.1:8080/redis/lockAgain?key=fanyidong
     * @param key
     * @return
     */
    @GetMapping("redis/lockAgain")
    public Object lockAgain(String key) {
        if (redisService.get(key)==null) {
            return false;
        }
        return redisService.lock3(key, RedisService.ServerSingle + System.currentTimeMillis() + 10000, 10, TimeUnit.SECONDS);
    }

    /**
     * http://127.0.0.1:8080/redis/get?key=fanyidong
     * @param key
     * @return
     */
    @GetMapping("/redis/get")
    public Object get(String key) {
        return redisService.get(key);
    }
}
