package io.walkers.planes.pandora.design.patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Planeswalker23
 */
public class BaseInfoFactory {

    private Map<String, BaseInfo> baseInfoMap = new HashMap<>();

    public void add(String key, BaseInfo value) {
        baseInfoMap.put(key, value);
    }

    public BaseInfo getBaseInfo(String key) {
        return this.baseInfoMap.get(key);
    }
}
