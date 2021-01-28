package io.walkers.planes.pandora.jvm.classloader.initialize;

import java.util.UUID;

/**
 * 类加载机制初始化阶段被动引用示例：一个接口在初始化时，并不要求其父接口全部都完成了初始化，只有在真正使用到父接口的时候（如引用接口中运行期才确定的常量）才会初始化。
 * @author Planeswalker23
 * @date Created in 2020/4/28
 */
public class InterfaceDemo {

    public static void main(String[] args) {
        System.out.println(ChildInterface.parentRand);
    }
}

interface ParentInterface {
    int parentA = 1/0;
    String parentRand = UUID.randomUUID().toString();
}

interface ChildInterface extends ParentInterface {
    String childRand = UUID.randomUUID().toString();
}