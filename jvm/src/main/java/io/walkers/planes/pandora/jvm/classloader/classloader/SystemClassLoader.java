package io.walkers.planes.pandora.jvm.classloader.classloader;

import sun.misc.Launcher;

/**
 * 24. 平台特定的启动类加载器
 * sun.boot.class.path 配置路径不可改, 改了后会报错jvm初始化错误
 * 扩展类加载器和应用类加载器和自定义的加载器由启动类加载器加载，启动类加载器内建于JVM，当虚拟机启动时就会存在。
 * @author Planeswalker23
 * @date Created in 2020/4/24
 */
public class SystemClassLoader {

    public static void main(String[] args) {
//        modifyBootstrapClassPath();
//        findParentClassLoader();
        modifySystemClassLoader();
    }

    /**
     * sun.boot.class.path 配置路径不可改, 改了后会报错jvm初始化错误
     * 1. cd /Users/fan/workspace/all-in-one/jvm/target/classes
     * 2. java -Dsun.boot.class.path=./ classloader.classloader.SystemClassLoader
     *
     * output:
     *       Error occurred during initialization of VM
     *       java/lang/NoClassDefFoundError: java/lang/Object
     */
    public static void modifyBootstrapClassPath() {
        System.out.println(System.getProperty("sun.boot.class.path"));
    }

    /**
     * 扩展类加载器和应用类加载器也是由启动类加载器加载的
     */
    public static void findParentClassLoader() {
        System.out.println(ClassLoader.class.getClassLoader());
        // AppClassLoader 和 ExtClassLoader 存在于 Launcher 类中
        System.out.println(Launcher.class.getClassLoader());
    }

    /**
     * 修改默认的系统类加载器，需要为MyClassLoader添加新的构造器，接收一个ClassLoader类作为父类加载器
     * 1. cd /Users/fan/workspace/all-in-one/jvm/target/classes
     * 2. java -Djava.system.class.loader=classloader.classloader.MyClassLoader classloader.classloader.SystemClassLoader
     */
    public  static void modifySystemClassLoader() {
        System.out.println("java.system.class.loader");
        System.out.println(SystemClassLoader.class.getClassLoader());
        // output: classloader.classloader.MyClassLoader@4e25154f
        System.out.println(ClassLoader.getSystemClassLoader());
    }

}
