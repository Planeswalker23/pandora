package io.walkers.planes.pandora.design.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题（被观察者）抽象类
 * Subject被观察者：定义被观察者必须实现的职责，它必须能够动态地增加、取消观察者（管理观察者），并通知观察者。
 * @author Planeswalker23
 * @date Created in 2019-08-29
 */
public abstract class Subject {

    private List<Observer> observers = new ArrayList<>();

    /**
     * 增加观察者
     * @param o
     */
    public void add(Observer o) {
        observers.add(o);
        System.out.println("用户 " + o.getUserName() + " 关注");
    }

    /**
     * 减少观察者
     * @param o
     */
    public void delete(Observer o) {
        observers.remove(o);
        System.out.println("用户 " + o.getUserName() + " 取关");
    }

    /**
     * 通知所有观察者
     * @param msg
     */
    public void notifyObservers(String msg) {
        for (Observer o:observers) {
            o.update(msg);
        }
    }
}
