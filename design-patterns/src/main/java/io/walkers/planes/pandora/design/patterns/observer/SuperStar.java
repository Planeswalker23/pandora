package io.walkers.planes.pandora.design.patterns.observer;

/**
 * 被观察者：巨星的微博
 * 具体的被观察者：定义被观察者自己的业务逻辑，同时定义对哪些事件进行通知。
 * @author Planeswalker23
 * @date Created in 2019-08-29
 */
public class SuperStar extends Subject {

    public void send(String msg) {
        System.out.println("巨星发微博了，内容是：" + msg);
        notifyObservers(msg);
    }
}
