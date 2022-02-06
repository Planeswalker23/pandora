package io.walkers.planes.pandora.design.patterns.strategy.v2;

/**
 * @author Planeswalker23
 */
public class Email implements Notify {
    @Override
    public void doNotify(Message msg) {
        System.out.printf("[%s]使用[邮件]通知[%s], 通知内容为[%s]\n", msg.getSender(), msg.getReceiver(), msg.getContext());
    }
}
