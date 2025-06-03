package io.walkers.planes.pandora.jdk.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 范逸东(东稚)
 */
public class TestStream {

    public static void main(String[] args) {
        int size = 20000000;
        List<User> list = getUsers(size);

        Map<Long, String> nameMap = new HashMap<>();
        nameMap.put(0L, "0");
        nameMap.put(1L, "1");

        Map<Long, String> genderMap = new HashMap<>();
        genderMap.put(0L, "男");
        genderMap.put(1L, "女");

        long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            exec(list.get(i), nameMap, genderMap);
        }
        long end = System.currentTimeMillis();
        System.out.println("1: " + (end - start));

        start = System.currentTimeMillis();
        list.forEach(user -> exec(user, nameMap, genderMap));
        end = System.currentTimeMillis();
        System.out.println("2: " + (end - start));

        start = System.currentTimeMillis();
        list = list.stream().peek(user -> exec(user, nameMap, genderMap)).collect(Collectors.toList());
        end = System.currentTimeMillis();
        System.out.println("3: " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            execName(list.get(i), nameMap);
        }
        for (int i = 0; i < list.size(); i++) {
            execName(list.get(i), genderMap);
        }
        end = System.currentTimeMillis();
        System.out.println("4: " + (end - start));

        start = System.currentTimeMillis();
        list.forEach(user -> execName(user, nameMap));
        list.forEach(user -> execGender(user, genderMap));
        end = System.currentTimeMillis();
        System.out.println("5: " + (end - start));

    }

    private static void exec(User user, Map<Long, String> nameMap, Map<Long, String> genderMap) {
        Long key = user.getId() % 2;
        if (nameMap.containsKey(key)) {
            user.setName(nameMap.get(key));
        }
        if (genderMap.containsKey(key)) {
            user.setGender(genderMap.get(key));
        }
    }

    private static void execName(User user, Map<Long, String> nameMap) {
        Long key = user.getId() % 2;
        if (nameMap.containsKey(key)) {
            user.setName(nameMap.get(key));
        }
    }

    private static void execGender(User user, Map<Long, String> genderMap) {
        Long key = user.getId() % 2;
        if (genderMap.containsKey(key)) {
            user.setName(genderMap.get(key));
        }
    }

    private static List<User> getUsers(int size) {
        List<User> list = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            User user = new User((long) i);
            list.add(user);
        }
        return list;
    }
}
