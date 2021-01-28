package io.walkers.planes.pandora.jvm.classloader.initialize;

/**
 * @author Planeswalker23
 * @date Created in 2020/4/28
 */
public class HelloWorld implements MyInterface {

    public static void main(String[] args){
        System.out.println(obj);
    }
}

class MyObject {
    static {
        System.out.println("MyObject 类初始化...");
    }
}

interface MyInterface {
    MyObject obj = new MyObject();
}
