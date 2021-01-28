package io.walkers.planes.pandora.jvm.bytecode.proxy;

/**
 * 实际被代理的类
 * @author Planeswalker23
 * @date Created in 2020/5/22
 */
public class ReadSubject implements Subject{
    /**
     * 被代理类需要实现的接口方法
     */
    @Override
    public void dothing() {
        System.out.println("ReadSubject#dothing");
    }
}
