package ioc.bean.lifecycle;

/**
 * 用户类 演示生命周期
 *
 * @author planeswalker23
 */
public class UserLifeCycle {
    private String name;

    public UserLifeCycle() {
        System.out.println("1. 执行构造方法创建实例");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("2. 调用 set 方法为属性赋值");
    }

    public void init() {
        System.out.println("3. 执行初始化方法");
    }

    public void destroy() {
        System.out.println("5. 执行销毁方法");
    }
}
