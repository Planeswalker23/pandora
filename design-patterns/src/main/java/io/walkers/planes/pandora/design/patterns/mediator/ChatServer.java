package io.walkers.planes.pandora.design.patterns.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介者角色：聊天服务器
 *
 * @author planeswalker23
 * @date 2022/2/22
 */
public class ChatServer {

    private List<User> users = new ArrayList<>();

    public void register(User user) {
        users.add(user);
        user.setChatServer(this);
        System.out.println("用户" + user.getUsername() + "加入聊天室");
    }

    public void reply(Message message) {
        for (User user1:users) {
            if (message.getTargetGroup().equals(user1.getGroup())) {
                user1.receive(message);
            }
        }
    }
}
