package io.walkers.planes.pandora.jvm.classloader.classloader;

/**
 * 27.28. 线程上下文类加载器
 * 当前类加载器（Current ClassLoader）：每个类都会使用自己的类加载器（即加载自身的类加载器）去加载所依赖的类（如果依赖类未被加载）。
 * 线程上下文类加载器（Thread Context CLassLoader）：{@link Thread}类中的{@link Thread#getContextClassLoader()}与{@link Thread#setContextClassLoader(ClassLoader)} ()}分别用来获取和设置上下文类加载器。
 * 如果没有通过{@link Thread#setContextClassLoader(ClassLoader)} ()}进行设置的话，线程将继承其父线程的上下文类加载器，Java应用运行时的初始线程的上下文类加载器是系统类加载器(AppClassLoader)，在线程中的代码可以通过类加载器来加载类与资源。
 *
 * 线程上下文类加载器的重要性：
 *      SPI(Service Provider Interface)
 *      父加载器可以使用当前线程的{@link Thread#getContextClassLoader()}指定的类加载器所加载的类。这就改变了父加载器不能使用子加载器或是其他没有直接父子关系的类加载器加载类的情况，即打破了双亲委托模型。
 *
 * 线程上下文类加载器就是当前线程的Current ClassLoader。
 * 在双亲委托模型下，类加载是由下至上的，即下层的类加载会委托上层进行加载。
 * 但是对于SPI来说，有些接口是Java核心类库锁提供的，而Java核心库是由启动类加载器来加载的，而这些接口的实现却来自于不同的jar包，Java的启动类加载器是不会加载其他来源的jar包，这样传统的双亲委托模型就无法满足SPI的要求。
 * 而通过给当前线程设置上下文加载器，就可以由设置的上下文类加载器来实现对于接口的实现类的加载。
 *
 * @author Planeswalker23
 * @date Created in 2020/4/26
 */
public class ThreadContextClassLoader {

    public static void main(String[] args) {
        outContextThreadClassLoader();
    }

    /**
     * 输出当前线程的类加载器和Thread类的类加载器
     * sun.misc.Launcher$AppClassLoader@18b4aac2
     * null
     */
    public static void outContextThreadClassLoader() {
        // output: AppClassLoader
        System.out.println(Thread.currentThread().getContextClassLoader());
        // Thread类位于java.lang包 -> output¬: null
        System.out.println(Thread.class.getClassLoader());
    }
}
