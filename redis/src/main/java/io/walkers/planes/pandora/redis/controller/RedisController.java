package io.walkers.planes.pandora.redis.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.walkers.planes.pandora.redis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/redis/get")
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
}
