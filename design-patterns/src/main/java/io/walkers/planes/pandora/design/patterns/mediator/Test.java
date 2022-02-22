package io.walkers.planes.pandora.design.patterns.mediator;

/**
 * @author planeswalker23
 * @date 2022/2/22
 */
public class Test {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        User user1 = new User("user1", "A");
        User user2 = new User("user2", "A");
        User user3 = new User("user3", "B");
        chatServer.register(user1);
        chatServer.register(user2);
        chatServer.register(user3);

        Message message = new Message("你好", "A", user3);
        user3.send(message);
    }
}
