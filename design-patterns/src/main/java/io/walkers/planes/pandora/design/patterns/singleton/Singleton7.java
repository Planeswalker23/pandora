package io.walkers.planes.pandora.design.patterns.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例模式
 * 第七种写法：基于容器实现单例
 * @author Planeswalker23
 * @date Created in 2019-08-26
 */
public class Singleton7 {

    private static Map<String, Object> objMap = new HashMap<>();

    public static void registerService(String key, Object instance) {
        if (!objMap.containsKey(key)) {
            objMap.put(key, instance);
        }
    }

    public static Object getService(String key) {
        return objMap.get(key);
    }
}

