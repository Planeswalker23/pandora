package io.walkers.planes.pandora.spring.bean.lifecycle;

/**
 * @author planeswalker23
 * @date 2021/11/22
 */
public class User {

    private String name;

    public User(String name) {
        this.name = name;
        System.out.println("User 对象正在实例化");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
