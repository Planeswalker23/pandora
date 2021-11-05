package io.walkers.planes.pandora.ioc.inject;

/**
 * 基于 XML 配置文件创建对象，基于 setter 方法注入属性
 *
 * @author 范逸东(东稚)
 */
public class User {

    private String name;

    // setter 方式注入要求有无参构造器及 setter 方法
    public User() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    private Integer age;

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}' + super.toString();
    }
}
