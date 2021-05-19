package io.walkers.planes.pandora.jdk;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.*;

/**
 * {@link Serializable} 测试类
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

