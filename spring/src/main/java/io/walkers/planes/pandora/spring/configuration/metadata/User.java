package io.walkers.planes.pandora.spring.configuration.metadata;

/**
 * @author planeswalker23
 * @date 2021/11/24
 */
public class User {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
