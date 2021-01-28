package io.walkers.planes.pandora.design.patterns.observer;

/**
 * 观察者A，收到更新后的行为:点赞
 * @author Planeswalker23
 * @date Created in 2019-08-29
 */
public class UserA implements Observer {

    private String name;

    public UserA(String name) {
        this.name = name;
    }

    @Override
    public String getUserName() {
        return this.name;
    }

    @Override
    public void update(String msg) {
        System.out.println(this.name + "收到某人发新微博的通知，并点了个赞");
    }
}
