package io.walkers.planes.pandora.spring.dependency.injection;

/**
 * 依赖注入类
 *
 * @author planeswalker23
 * @date 2021/11/21
 */
public class WayOfDIUser {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public WayOfDIUser() {
    }

    public WayOfDIUser(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WayOfDIUser{" +
                "name='" + name + '\'' +
                '}';
    }
}
