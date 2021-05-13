package io.walkers.planes.pandora.design.patterns.singleton;

import java.io.*;

/**
 * 验证单例模式的反序列化
 * @author Planeswalker23
 * @date Created in 2019-08-27
 */
public class SingletonSerializableCheck {

    /**
     * 序列化单例对象
     * 把对象转换为字节序列的过程称为对象的序列化
     * @param instance
     * @param filePath
     * @throws Exception
     */
    private static void writeEnum(Object instance, String filePath) throws Exception {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File(filePath)));
        outputStream.writeObject(instance);
        outputStream.close();
    }

    /**
     * 单例对象反序列化
     * 把字节序列恢复为对象的过程称为对象的反序列化
     * @param filePath
     * @return
     * @throws Exception
     */
    private static Object readEnum(String filePath) throws Exception {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File(filePath)));
        return inputStream.readObject();
    }

    public static void main(String[] args) throws Exception {
        // 被检测的单例对象
        Object checkedSingletonObj = Singleton1.getInstance();
        // 文件路径
        String filePath = "design-patterns/src/main/java/io/walkers/planes/pandora/design/patterns/singleton/SingletonEnumCheck.dat";
        // 序列化单例对象
        writeEnum(checkedSingletonObj, filePath);
        // out：true，说明反序列化后，枚举类也是单例的；false，说明反序列化生成了新的对象
        System.out.println("序列化前的对象：" + checkedSingletonObj);
        Object afterSerializableObj = readEnum(filePath);
        System.out.println("反序列化后的对象：" + afterSerializableObj);
        System.out.println("是否是同一个对象：" + (checkedSingletonObj == afterSerializableObj));
    }
}
