package io.walkers.planes.pandora.jvm.classloader.classloader.namespace;

import io.walkers.planes.pandora.jvm.classloader.classloader.MyClassLoader;

/**
 * 类加载器的命名空间示例
 *
 * 父类加载器加载的类无法访问子加载器加载的类
 * 子类加载器加载的类可以访问父加载器加载的类
 *
 * 若在一个类 ClassA 的构造器中创建另外一个类 ClassB 的实例，那么会由 ClassA 的类加载器尝试加载 ClassB 类
 *
 * @author Planeswalker23
 * @date Created in 2020/4/24
 */
public class NameSpaceDemo {

    public static void main(String[] args) throws Exception {
        demo3();
    }

    /**
     * 1. 删除 classpath 下的 ClassB, 保留 ClassA
     * 在 ClassA 类的构造函数中创建 ClassB 类的实例，会去尝试加载 ClassB 类，但是 ClassPath 下的 ClassB 类已被删除，所以抛出 NoClassDefFoundError
     * （虽然 loader1 加载器的加载目录中有 ClassB 类，但是 AppClassLoader 无法加载 loader1 中的类）
     * 得出结论：ClassB 的类加载器是 ClassA 类的类加载器， 即父加载器加载的类无法访问子加载器加载的类
     */
    public static void demo1() throws Exception {
        MyClassLoader loader1 = new MyClassLoader("loader1");
        loader1.setPath("/Users/fan/Downloads/");
        Class<?> clazz = loader1.loadClass("classloader.classloader.namespace.ClassA");
        System.out.println("clazz.hashCode() = " + clazz.hashCode());
        // 创建类的实例，调用构造方法，保留应用类加载器加载目录中的Sample和Cat字节码文件，所以他们的类加载器是AppClassLoader
        Object object = clazz.newInstance();
    }

    /**
     * 2. 删除 classpath 下的 ClassA, 保留 ClassB
     * ClassA 的类加载器是 MyClassLoader, ClassB 的类加载器是 AppClassLoader
     * ClassB 由于双亲委托机制, 会向上委托加载发现 AppClassLoader 可以加载, 因此由 AppClassLoader 加载
     */
    public static void demo2() throws Exception {
        MyClassLoader loader1 = new MyClassLoader("loader1");
        loader1.setPath("/Users/fan/Downloads/");
        Class<?> clazz = loader1.loadClass("classloader.classloader.namespace.ClassA");
        System.out.println("clazz.hashCode() = " + clazz.hashCode());
        // 创建类的实例，调用构造方法，保留应用类加载器加载目录中的Sample和Cat字节码文件，所以他们的类加载器是AppClassLoader
        Object object = clazz.newInstance();
    }

    /**
     * 3. ClassB 的构造器中加入这么一句话: System.out.println("from ClassB: " + ClassA.class);
     *    然后删除 classpath 下的 ClassA
     * 在 ClassB 类构造器中加入的代码报错: NoClassDefFoundError， 因为 ClassB 的类加载器是 AppClassLoader 而 ClassA 的类加载器是 MyClassLoader，父类加载器是无法访问子类加载器加载的类的
     */
    public static void demo3() throws Exception {
        MyClassLoader loader1 = new MyClassLoader("loader1");
        loader1.setPath("/Users/fan/Downloads/");
        Class<?> clazz = loader1.loadClass("classloader.classloader.namespace.ClassA");
        System.out.println("clazz.hashCode() = " + clazz.hashCode());
        // 创建类的实例，调用构造方法，保留应用类加载器加载目录中的Sample和Cat字节码文件，所以他们的类加载器是AppClassLoader
        Object object = clazz.newInstance();
    }
}
