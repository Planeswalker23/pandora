package io.walkers.planes.pandora.jvm.classloader.classloader;

import java.io.*;

/**
 * 自定义的类加载器
 *
 * @author Planeswalker23
 * @purpose {@link ClassLoader#loadClass(String)} 验证该方法
 * 1. 检查该类是否已经被加载
 * 2. 若没有被加载，且本类加载器的父类加载器不为空，将请求委托给父类加载器去加载该类（递归）
 * 3. 若父类加载为空，调用该类加载器的 {@link ClassLoader#findClass(String)} 方法去找到这个类，并完成加载
 * @date Created in 2020/4/22
 */
public class MyClassLoader extends ClassLoader {

    private String classLoaderName;
    /**
     * 文件扩展名
     */
    private final String fileExtension = ".class";
    /**
     * 文件路径，作为当前加载器加载文件的路径
     */
    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 默认父加载器为SystemClassLoader的构造方法
     *
     * @param classLoaderName
     */
    public MyClassLoader(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    /**
     * 父加载器为指定的parent的构造方法
     *
     * @param parent
     * @param classLoaderName
     */
    public MyClassLoader(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    /**
     * java -Djava.system.class.loader=classloader.classloader.MyClassLoader
     * @param parent
     */
    public MyClassLoader(ClassLoader parent) {
          super(parent);
    }

    /**
     * 重写父类的findClass方法
     * 若调用本类加载器，会执行本方法
     *
     * @param className
     * @return Class
     */
    @Override
    protected Class<?> findClass(String className) {
        System.out.println("执行 MyClassLoader 的加载方法: class loaded by MyClassLoader@: " + this.classLoaderName);
        // 调用loadClassData方法加载类信息，本例中是加载外部二进制流文件
        byte[] data = this.loadClassData2ByteArray(className);
        return this.defineClass(className, data, 0, data.length);
    }

    /**
     * 加载类的信息以 byte[] 形式返回
     *
     * @param name
     * @return byte[]
     */
    private byte[] loadClassData2ByteArray(String name) {
        // 声明三个对象
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        // 包名转为路径名
        name = name.replace(".", "/");
        try {
            // 字节流读取指定的字节码文件
            is = new FileInputStream(new File(this.path + name + this.fileExtension));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while ((ch = is.read()) != -1) {
                baos.write(ch);
            }
            // 将读取到的字节流转为字节数组
            data = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert is != null;
                is.close();
                assert baos != null;
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
//        test3();
        testFindLoadedClass();
    }

    /**
     * 由 AppClassLoader 完成加载 MyObject 类的加载请求
     *
     * @throws Exception
     */
    public static void test1() throws Exception {
        // 创建一个自定义类加载器，名称是loader1,它的父类加载器是 AppClassLoader，所以不会由 MyClassLoader 类加载
        MyClassLoader loader1 = new MyClassLoader("loader1");
        loader1.setPath("/Users/fan/workspace/all-in-one/jvm/target/classes/");

        // 尝试加载 MyObject 类
        Class<?> loadClass = loader1.loadClass("classloader.classloader.MyObject");
        Class<?> loadClass2 = loader1.loadClass("classloader.classloader.MyObject");
        System.out.println(loadClass.hashCode());

        // 创建 MyObject 类实例
        Object instance = loadClass.newInstance();
        System.out.println(instance);
        System.out.println(instance.getClass().getClassLoader());
    }

    /**
     * 1. 将 target 目录中的 MyObject 文件移动到新的目录，并将该目录作为指定加载路径，再次尝试加载类，这次父类加载器变成了 MyClassLoader
     * 原因：AppClassLoader 的 CLASSPATH 中没有找到该类，即 AppClassLoader 未能完成加载，将加载请求返回给其子类——MyClassLoader，由 MyClassLoader 完成加载
     * <p>
     * 2. 再创建一个类加载器，加载同一目录下的同一个类，发现两个类加载器加载出来的类 hash 值不同
     * 原因：每个类加载器都有自己的命名空间，命名空间由该类加载器及所有父类加载所加载的类组成。
     * 在同一个命名空间中，不会出现类的全限定名相同的两个类；反之在不同的命名空间中，可能会出现类的全限定名相同的两个类。
     *
     * @throws Exception
     */
    public static void test2() throws Exception {
        // 创建一个自定义类加载器，名称是loader1,它的父类加载器是 AppClassLoader
        MyClassLoader loader1 = new MyClassLoader("loader1");
        loader1.setPath("/Users/fan/Downloads/");

        // 尝试加载 MyObject 类
        Class<?> clazz = loader1.loadClass("classloader.classloader.MyObject");
        System.out.println("当前类的 hashcode: " + clazz.hashCode());
        System.out.println("当前类的类加载器是: " + clazz.getClassLoader());

        System.out.println("----------");

        MyClassLoader loader2 = new MyClassLoader("loader2");
        loader2.setPath("/Users/fan/Downloads/");
        Class<?> clazz2 = loader2.loadClass("classloader.classloader.MyObject");
        System.out.println("当前类的 hashcode: " + clazz2.hashCode());
        System.out.println("当前类的类加载器是: " + clazz2.getClassLoader());
    }

    /**
     * 将 target 目录中的 MyObject 文件移动到新的目录，并将该目录作为指定加载路径
     * 同时将 loader2 的父加载器指定为 loader1
     * loader3 与 loader1 一致 / loader3 的父加载器指定为 loader2
     *
     * @throws Exception
     */
    public static void test3() throws Exception {
        // 创建一个自定义类加载器，名称是loader1,它的父类加载器是 AppClassLoader
        MyClassLoader loader1 = new MyClassLoader("loader1");
        loader1.setPath("/Users/fan/Downloads/");

        // 尝试加载 MyObject 类
        Class<?> clazz = loader1.loadClass("classloader.classloader.MyObject");
        System.out.println("当前类的 hashcode: " + clazz.hashCode());
        System.out.println("当前类的类加载器是: " + clazz.getClassLoader());

        System.out.println("----------");

        // 将loader2的父加载器设置为loader1
        MyClassLoader loader2 = new MyClassLoader(loader1, "loader2");
        loader2.setPath("/Users/fan/Downloads/");
        Class<?> clazz2 = loader2.loadClass("classloader.classloader.MyObject");
        System.out.println("当前类的 hashcode: " + clazz2.hashCode());
        System.out.println("当前类的类加载器是: " + clazz2.getClassLoader());

        System.out.println("----------");

        MyClassLoader loader3 = new MyClassLoader(loader2, "loader3");
        loader3.setPath("/Users/fan/Downloads/");
        Class<?> clazz3 = loader3.loadClass("classloader.classloader.MyObject");
        System.out.println("当前类的 hashcode: " + clazz3.hashCode());
        System.out.println("当前类的类加载器是: " + clazz3.getClassLoader());
    }

    /**
     * 卸载类示例，需要保证 class 的类加载器是自定义的类加载器，同时删除 CLASSPATH 中 MyObject 的字节码文件（/Users/fan/workspace/all-in-one/jvm/target/classes/）
     * -XX:+TraceClassUnLoading 打印类卸载信息
     *
     * @throws Exception
     * @output 如下： 其中 [Unloading class classloader.classloader.MyObject 0x00000007c0061028] 代表该类被卸载
     * 执行 MyClassLoader 的加载方法: class loaded by MyClassLoader@: loader1
     * 1360875712
     * classloader.classloader.MyObject@60e53b93
     * ----------
     * 执行 MyClassLoader 的加载方法: class loaded by MyClassLoader@: loader1
     * 644117698
     * classloader.classloader.MyObject@6f94fa3e
     * [Unloading class classloader.classloader.MyObject 0x00000007c0061028]
     */
    public static void unloadClass() throws Exception {
        MyClassLoader loader1 = new MyClassLoader("loader1");
        loader1.setPath("/Users/fan/Downloads/");

        // 尝试加载 MyObject 类
        Class<?> clazz = loader1.loadClass("classloader.classloader.MyObject");
        System.out.println(clazz.hashCode());

        // 创建 MyObject 类实例
        Object instance = clazz.newInstance();
        System.out.println(instance);

        System.out.println("----------");

        // 将引用指向新的地址
        loader1 = new MyClassLoader("loader1");
        loader1.setPath("/Users/fan/Downloads/");
        clazz = loader1.loadClass("classloader.classloader.MyObject");
        System.out.println(clazz.hashCode());
        instance = clazz.newInstance();
        System.out.println(instance);

        // 模拟垃圾回收，使得类被卸载
        System.gc();

        // 通过 jvisualvm 程序运行情况
//        Thread.sleep(200000);
    }

    /**
     * 测试加载类时，findLoadedClass 的检查范围
     * @see ClassLoader#findLoadedClass(String)
     * @throws ClassNotFoundException
     */
    private static void testFindLoadedClass() throws ClassNotFoundException {
        MyClassLoader loader = new MyClassLoader("loader1");
        loader.setPath("/Users/fan/Downloads/");
        Class<?> clazz = loader.loadClass("classloader.classloader.MyObject");
        // 第二次发起加载该类的请求时，跟踪到ClassLoader源码中 ，发现自定义类加载器检查该类是否已被加载过时，返回的是空。
        // 是由MyObject类的类加载器AppClassLoader检查到该类已被加载的
        Class<?> clazz2 = loader.loadClass("classloader.classloader.MyObject");
    }
}
