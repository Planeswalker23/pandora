package ioc.bean;

/**
 * 用户类
 *
 * @author planeswalker23
 */
public class User {

    private String name;

    // setter 方式注入要求有无参构造器及 setter 方法
    public void setName(String name) {
        this.name = name;
    }

    // setter 方式注入要求有无参构造器及 setter 方法
    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    private Integer age;

    // setter 方式注入要求有无参构造器及 setter 方法
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
