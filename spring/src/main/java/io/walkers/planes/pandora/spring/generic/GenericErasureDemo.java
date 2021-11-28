package io.walkers.planes.pandora.spring.generic;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 泛型擦除问题示例
 *
 * @author planeswalker23
 * @date 2021/11/28
 */
public class GenericErasureDemo {

    @Test
    public void erasure() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Collection<String> list = new ArrayList<>();
        list.add("Hello World");
        // 编译时错误
        // list.add(1);

        // 1. 泛型擦除
        Collection list2 = list;
        // 编译通过
        list2.add(1);

        // 2. 通过反射添加其他类型元素
        list.getClass().getMethod("add", Object.class).invoke(list, 2);

        Collection<Integer> list3 = new ArrayList<>();
        System.out.println(list.getClass() == list3.getClass());

        System.out.println(list2);
    }
}
