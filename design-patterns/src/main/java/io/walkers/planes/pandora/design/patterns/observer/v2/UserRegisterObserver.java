package io.walkers.planes.pandora.design.patterns.observer.v2;

/**
 * 用户注册类观察者
 *
 * @author Planeswalker23
 */
public class UserRegisterObserver implements Observer {
    @Override
    public void response(String userName) {
        System.out.println("[用户注册观察者]用户: [" + userName + "]已注册，发放新人福利：88元红包");
    }
}
