package io.walkers.planes.pandora.design.patterns.observer;

/**
 * 观察者抽象接口
 * Observer观察者：观察者接收到消息后，即进行update（更新方法）操作，对接收到的信息进行处理。
 * @author Planeswalker23
 * @date Created in 2019-08-29
 */
public interface Observer {

    /**
     * 获取观察者的微博用户名
     * @return String
     */
    String getUserName();

    /**
     * 通知更新方法
     * 当被观察者发生变化时，观察者通过这个方法获得通知
     * @param msg 发微博的内容
     */
    void update(String msg);
}
