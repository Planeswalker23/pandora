package io.walkers.planes.pandora.jdk;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试 Map<String, Object> 对象的 clone
 * @author planeswalker23
 * @date 2021/1/28
 */
public class TestCloneMap {

    boolean isDown;

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("String", "String");
        map.put("createTime", new Timestamp(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()).getTime()));
        System.out.println(map.toString());

        //  通过 Object#clone 进行拷贝
        Map<String, Object> map2 = (Map<String, Object>) ((HashMap<String, Object>) map).clone();

        //  通过 fastjson 进行拷贝
        Map<String, Object> map3 = JSON.parseObject(JSON.toJSONString(map), HashMap.class);

        //  通过 gson 进行拷贝
        Gson gson = new Gson();
        Map<String, Object> map4 = gson.fromJson(gson.toJson(map), HashMap.class);

        // 测试 putAll 存在同 key 时如何处理
        Map<String, Object> expandMap = new HashMap<>();
        expandMap.put("String", "String");
        map.put("createTime", new Timestamp(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()).getTime()));
        map.putAll(expandMap);
        map.putAll(map);

        System.out.println(map.toString());

        // 测试 boolean 的默认值
        TestCloneMap bean = new TestCloneMap();
        System.out.println(bean.isDown?"true":"false");

        // 测试 Collections.unmodifiableMap
        Map<String, Object> unmodifiableMap = Collections.unmodifiableMap(map);
        Map<String, Object> expandMap2 = new HashMap<>();
        expandMap2.putAll(unmodifiableMap);
        System.out.println(expandMap2);

    }
}
