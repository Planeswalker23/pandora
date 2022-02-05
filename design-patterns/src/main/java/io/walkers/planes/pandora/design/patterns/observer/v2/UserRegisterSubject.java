package io.walkers.planes.pandora.design.patterns.observer.v2;

/**
 * 用户注册类被观察者
 *
 * @author Planeswalker23
 */
public class UserRegisterSubject extends Subject {

    @Override
    public void notifyObservers(String msg) {
        for (Observer observer : observers) {
            // 只通知用户注册类观察者
            if (observer instanceof UserRegisterObserver) {
                observer.response(msg);
            }
        }
    }
}
