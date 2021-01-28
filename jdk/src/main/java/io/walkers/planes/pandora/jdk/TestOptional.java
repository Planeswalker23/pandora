package io.walkers.planes.pandora.jdk;

import java.util.Optional;

/**
 * {@link Optional}
 * @author Planeswalker23
 * @date Created in 2020/4/10
 */
public class TestOptional {

    public static void main(String[] args) {
        Integer num =  null;
        System.out.println("num原始数据=" + num);
        // 不改变原来的对象，只是遇到null后返回新的值或对象
        System.out.println("经Optional操作后的num=" + Optional.ofNullable(num).orElse(0));
        System.out.println("later:" + num);
    }
}
