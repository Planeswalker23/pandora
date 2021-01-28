package io.walkers.planes.pandora.jvm.classloader.classloader.namespace;

import io.walkers.planes.pandora.jvm.classloader.classloader.MyClassLoader;
import io.walkers.planes.pandora.jvm.classloader.classloader.MyObject;
import com.sun.crypto.provider.AESKeyGenerator;

import java.lang.reflect.Method;

/**
 * 21. 类加载器实战剖析与疑难点解析
 * 22. 类加载器命名空间深度解析与实例分析
 * @author Planeswalker23
 * @date Created in 2020/4/24
 */
public class NameSpaceDemo2 {

    public static void main(String[] args) throws Exception {
//        showPath();
//        extensionDemo();
        namespaceDemo();
    }

    /**
     * 1. 打印各种加载器的加载路径
     */
    public static void showPath() {
        System.out.println("启动类加载器 Bootstrap ClassLoader 加载路径");
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println("扩展类加载器 Extension ClassLoader 加载路径");
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println("系统/应用类加载器 System/App ClassLoader 加载路径");
        System.out.println(System.getProperty("java.class.path"));
    }

    /**
     * 2. 扩展类加载器示例
     * 将 java.ext.dirs 的值(扩展类加载器的加载目录)变更为./ 即当前目录，然后启动 NameSpaceDemo2 类
     * java -Djava.ext.dirs=./ classloader.classloader.namespace.NameSpaceDemo2
     */
    public static void extensionDemo() {
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(NameSpaceDemo2.class.getClassLoader());
    }

    /**
     * 类的命名空间示例
     * 1. 直接运行
     * 2. 删除 classpath 下的 MyObject 字节码文件，再运行
     * @see {@link MyObject#setMyObject(Object)}
     */
    public static void namespaceDemo() throws Exception {
        MyClassLoader loader1 = new MyClassLoader("loader1");
        loader1.setPath("/Users/fan/Downloads/");
        Class<?> clazz1 = loader1.loadClass("classloader.classloader.MyObject");

        MyClassLoader loader2 = new MyClassLoader("loader2");
        loader2.setPath("/Users/fan/Downloads/");
        Class<?> clazz2 = loader2.loadClass("classloader.classloader.MyObject");

        // MyObject 类的类加载器为AppCLassLoader，所以无论是clazz1还是clazz2实际都是由 AppCLassLoader 加载的，所以结果为 true
        // 删除 classpath 下的 MyObject 字节码文件，它的类加载器变为 MyClassLoader，分别由两个 MyClassLoader 加载的 clazz1 和 clazz2 是两个不同命名空间下的类，所以结果为 false
        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        // 通过反射执行 setObject 方法
        // 如果是由两个 MyClassLoader 来加载的 MyObject 对象，会抛出 InvocationTargetException 异常
        // Caused by: java.lang.ClassCastException: classloader.classloader.MyObject cannot be cast to classloader.classloader.MyObject
        // 类的全路径名相同，但命名空间不同（由不同的类加载器加载，且没有父子级关系）
        Method method = clazz1.getMethod("setMyObject", Object.class);
        method.invoke(object1, object2);
    }
}
