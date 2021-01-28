package io.walkers.planes.pandora.jvm.classloader.classloader;

/**
 * 23. 扩展类加载器
 * 会加载被打包为jar包形式的class文件
 * @author Planeswalker23
 * @date Created in 2020/4/24
 */
public class ExtensionClassLoader {

    static {
        System.out.println("ExtensionClassLoader initializer");
    }

    /**
     * 1. 首先定位到 class 目录 cd /Users/fan/workspace/all-in-one/jvm/target/classes
     * 2. 将 MyObject 类打包为 jar 包放到当前目录: jar cvf demo.jar classloader/classloader/MyObject.class
     * 3. 指定当前目录为扩展类加载路径并启动 ExtensionClassLoader 类: java -Djava.ext.dirs=./ classloader.classloader.ExtensionClassLoader
     * @param args
     */
    public static void main(String[] args) {
        // 首先需要打成jar包
        System.out.println(ExtensionClassLoader.class.getClassLoader());

        System.out.println(MyObject.class.getClassLoader());
        System.out.println("java.ext.dirs=" + System.getProperty("java.ext.dirs"));
    }
}
