package io.walkers.planes.pandora.design.patterns.mediator;

/**
 * @author planeswalker23
 * @date 2022/2/22
 */
public class Message {
    // 发送内容
    private String content;
    // 发送组
    private String targetGroup;
    // 发送者
    private User sender;

    public Message(String content, String targetGroup, User sender) {
        this.content = content;
        this.targetGroup = targetGroup;
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTargetGroup() {
        return targetGroup;
    }

    public void setTargetGroup(String targetGroup) {
        this.targetGroup = targetGroup;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }
}
