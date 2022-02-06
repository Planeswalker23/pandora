package io.walkers.planes.pandora.design.patterns.strategy.v2;

/**
 * @author Planeswalker23
 */
public class Message {
    // 发送人
    private String sender;
    // 收件人
    private String receiver;
    // 内容
    private String context;

    public Message(String sender, String receiver, String context) {
        this.sender = sender;
        this.receiver = receiver;
        this.context = context;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getContext() {
        return context;
    }
}
