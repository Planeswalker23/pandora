package io.walkers.planes.pandora.design.patterns.strategy.v2;

/**
 * @author Planeswalker23
 */
public class NoticeCenter {

    private Notify notify;

    public void sendMessage(Message message) {
        // 真正进行消息触达的方法
        notify.doNotify(message);
    }

    public Notify getNotify() {
        return notify;
    }

    public void setNotify(Notify notify) {
        this.notify = notify;
    }
}
