package io.walkers.planes.pandora.design.patterns.template.v2;

/**
 * @author Planeswalker23
 */
public class CreateUserService implements BaseCreateService<User> {
    @Override
    public void validate(User user) {
        System.out.println("执行User模型校验方法");
    }

    @Override
    public void fill(User user) {
        System.out.println("执行User模型填充方法");
    }

    @Override
    public int create(User user) {
        System.out.println("执行User模型持久化方法");
        return 0;
    }

    // 覆盖父类接口默认实现，表示钩子函数需要执行
    @Override
    public boolean hook() {
        return true;
    }

    @Override
    public void postHandler(User user) {
        System.out.println("执行User模型后置业务方法，如创建成功后异步通知");
    }
}
