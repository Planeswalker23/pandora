package io.walkers.planes.pandora.jvm.classloader.initialize;

/**
 * 7.2 类加载的时机
 * 主动引用示例7——虚拟机启动时被标为启动类的类（包含main()方法）:
 * 会执行{@link DrivingQuoteDemo7}类的静态代码块，表示进行了类的初始化
 * @author Planeswalker23
 * @date Created in 2020/4/15
 */
public class DrivingQuoteDemo7 {

    static {
        System.out.println("DrivingQuoteDemo7 init...");
    }

    public static void main(String[] args) {
    }
}
