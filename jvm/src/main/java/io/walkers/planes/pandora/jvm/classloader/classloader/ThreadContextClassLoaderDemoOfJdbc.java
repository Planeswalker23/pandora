package io.walkers.planes.pandora.jvm.classloader.classloader;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 31. 线程上下文类加载器示例：JDBC
 * @author Planeswalker23
 * @date Created in 2020/4/27
 */
public class ThreadContextClassLoaderDemoOfJdbc {

    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("jdbc.drivers"));
        // 加载 Driver 的实现类
        // 可以不写，根据 SPI 规范，Java 程序会主动且自动去加载符合 SPI 规范且存在于 classpath 中 jar 包"META-INF.services"下文件中的描述为全限定名的类（具体的驱动实现类）
//        Class.forName("com.mysql.jdbc.Driver");
        // 建立连接
        // 1. 通过获得调用 DriverManager#getConnection 方法的类加载器再次加载类，目的是验证类加载器的命名空间是否一致
        // 2. 通过驱动的具体实现类建立连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "admin");
    }
}
