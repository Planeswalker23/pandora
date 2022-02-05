package io.walkers.planes.pandora.design.patterns.observer.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题（被观察者）抽象类
 * Subject被观察者：定义被观察者必须实现的职责，它必须能够动态地增加、取消观察者（管理观察者），并通知观察者。
 *
 * @author Planeswalker23
 * @date Created in 2019-08-29
 */
public abstract class Subject {

    // 观察者列表
    protected List<Observer> observers = new ArrayList<>();

    // 增加观察者
    public void add(Observer o) {
        observers.add(o);
    }

    // 删除观察者
    public void delete(Observer o) {
        observers.remove(o);
    }

    // 通知所有观察者
    public abstract void notifyObservers(String msg);
}
