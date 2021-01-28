package io.walkers.planes.pandora.jvm.classloader.prepare;

/**
 * 测试类
 * @author Planeswalker23
 * @date Created in 2020/4/21
 */
public class MyObject {

    /**
     * 测试原始类型的默认值
     */
    public static int anInt;
    public static float aFloat;
    public static double aDouble;
    public static short aShort;
    public static long aLong;
    public static char aChar;
    public static boolean aBoolean;
    public static byte aByte;
    /**
     * 测试引用类型的默认值
     */
    public static MyObject myObject;

    static {
        System.out.println("int 类型的默认值: " + anInt);
        System.out.println("float 类型的默认值: " + aFloat);
        System.out.println("double 类型的默认值: " + aDouble);
        System.out.println("short 类型的默认值: " + aShort);
        System.out.println("long 类型的默认值: " + aLong);
        System.out.println("char 类型的默认值:'\u0000'->" + aChar);
        System.out.println("boolean 类型的默认值: " + aBoolean);
        System.out.println("byte 类型的默认值: " + aByte);
        System.out.println("引用类型的默认值: " + myObject);
    }

}
