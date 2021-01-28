package io.walkers.planes.pandora.design.patterns.observer;

/**
 * 观察者B，收到更新后的行为:收藏微博
 * @author Planeswalker23
 * @date Created in 2019-08-29
 */
public class UserB implements Observer {

    private String name;

    public UserB(String name) {
        this.name = name;
    }

    @Override
    public String getUserName() {
        return this.name;
    }

    @Override
    public void update(String msg) {
        System.out.println(this.name + "收到某人发新微博的通知，并收藏了这条微博");
    }
}
