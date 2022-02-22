package io.walkers.planes.pandora.design.patterns.mediator;

/**
 * 同事角色：用户
 *
 * @author planeswalker23
 * @date 2022/2/22
 */
public class User {
    // 用户昵称
    private String username;
    // 用户群组
    private String group;
    // 用户所属聊天服务器
    private ChatServer chatServer;

    public User(String username, String group) {
        this.username = username;
        this.group = group;
    }

    // 接收消息
    public void receive(Message message) {
        System.out.println("用户" + this.username + "收到用户" + message.getSender().getUsername() + "发来的消息，内容为：" + message.getContent());
    }

    // 发送消息
    public void send(Message message) {
        System.out.println("用户" + this.username + "向群组" + this.group + "的用户发出消息，内容为：" + message.getContent());
        chatServer.reply(message);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public ChatServer getChatServer() {
        return chatServer;
    }

    public void setChatServer(ChatServer chatServer) {
        this.chatServer = chatServer;
    }
}
