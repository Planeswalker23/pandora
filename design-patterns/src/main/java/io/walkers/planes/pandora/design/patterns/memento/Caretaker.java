package io.walkers.planes.pandora.design.patterns.memento;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 备忘录管理者
 *
 * @author Planeswalker23
 */
public class Caretaker {

    // 由于存档需要保存多个精灵的状态，所以每个存档用一个 list 来存储
    private Map<String, List<Memento>> archiveMap = new HashMap<>();

    public List<Memento> getArchive(String key) {
        return archiveMap.get(key);
    }

    public void setArchiveMap(String key, List<Memento> archive) {
        archiveMap.put(key, archive);
    }
}
