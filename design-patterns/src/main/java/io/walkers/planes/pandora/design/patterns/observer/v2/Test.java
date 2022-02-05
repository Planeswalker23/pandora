package io.walkers.planes.pandora.design.patterns.observer.v2;

/**
 * @author Planeswalker23
 */
public class Test {

    public static void main(String[] args) {
        // 注册观察者
        Observer observer = new UserRegisterObserver();
        Subject subject = new UserRegisterSubject();
        subject.add(observer);

        // 模拟用户注册
        System.out.println("用户A注册成功");
        subject.notifyObservers("A");
    }
}
