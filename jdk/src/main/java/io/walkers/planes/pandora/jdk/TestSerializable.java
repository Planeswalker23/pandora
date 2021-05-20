package io.walkers.planes.pandora.jdk;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;

/**
 * {@link Serializable} 测试类
 *
 * 序列化前处理(替换序列化对象): writeReplace
 * 序列化: writeObject
 * 反序列化: readObject
 * 反序列化后对返回对象进行处理: readResolve
 *
 * 缺陷: 1. 无法跨语言
 *      2. 易被攻击(ObjectInputStream#readObject 能实例化所有类路径上的对象，可能破坏单例[通过重写 readResolve 返回原单例对象规避])
 *      3. 序列化后流太大(网络传输占用带宽多，影响吞吐量)
 *      4. 性能问题(耗时更长)
 *
 * @author planeswalker23
 * @see java.io.Serializable
 */
@Data
@AllArgsConstructor
public class TestSerializable implements Serializable {

    private String data;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TestSerializable sourceObject = new TestSerializable("1");

        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(sourceObject);
        objectOutputStream.flush();
        objectOutputStream.close();

        //反序列化
        FileInputStream fileInputStream = new FileInputStream("test.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        TestSerializable targetObject = (TestSerializable) objectInputStream.readObject();

        System.out.println(targetObject);
    }
}

