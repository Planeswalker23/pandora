package io.walkers.planes.pandora.design.patterns.prototype;

/**
 * 用户类
 *
 * @author planeswalker23
 */
public class User implements Cloneable {

    private String name;
    private int age;
    private Address address;

    public User(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 调用引用类型对象的 clone 方法进行深拷贝
        this.address = (Address) address.clone();
        return super.clone();
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + ", address=" + address + '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("杭州");
        User user = new User("以东", 18, address);
        System.out.println(user);
        User cloneUser = (User) user.clone();
        System.out.println(cloneUser);
    }
}

class Address implements Cloneable {
    private String addressName;

    public Address(String addressName) {
        this.addressName = addressName;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
