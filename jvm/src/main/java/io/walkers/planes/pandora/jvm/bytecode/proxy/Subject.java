package io.walkers.planes.pandora.jvm.bytecode.proxy;

/**
 * 动态代理，被代理类接口
 * @author Planeswalker23
 * @date Created in 2020/5/22
 */
public interface Subject {

    /**
     * 被代理类需要实现的接口方法
     */
    void dothing();
}
