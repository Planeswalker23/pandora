package io.walkers.planes.pandora.spring.bean.definition;

/**
 * 用户类
 *
 * @author planeswalker23
 * @date 2021/11/16
 */
public class User {

    private Integer id;
    private String name;

    // 静态方法实例化 Bean
    public static User createUser() {
        return new User();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString() + " User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
