package io.walkers.planes.pandora.jdk;

import java.lang.reflect.Field;

/**
 * 测试 {@link String}
 *
 * @author planeswalker23
 * @date 2021/9/1
 */
public class TestString {

    public static void main(String[] args) {
        String a = "abc";
        String b = new String("abc");
        String c = b.intern();
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
    }

    private void modifyStringByReflect() throws NoSuchFieldException, IllegalAccessException {
        String a = "abc";
        Field value = a.getClass().getDeclaredField("value");
        value.setAccessible(true);
        char[] chars = (char[]) value.get(a);
        System.out.println("原始内容：" + a);
        chars[0] = 'A';
        System.out.println("修改后内容：" + a);
    }
}
