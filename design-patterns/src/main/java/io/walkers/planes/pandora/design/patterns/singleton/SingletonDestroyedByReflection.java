package io.walkers.planes.pandora.design.patterns.singleton;

import java.lang.reflect.Constructor;

/**
 * 反射破坏单例
 *
 * @author Planeswalker23
 * @date Created in 2021-05-26
 */
public class SingletonDestroyedByReflection {

    public static void main(String[] args) throws Exception {
        Singleton1 s1 = Singleton1.getInstance();

        Constructor<Singleton1> constructor = Singleton1.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton1 s2 = constructor.newInstance();

        System.out.println(s1 == s2);
    }
}
