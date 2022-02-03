package io.walkers.planes.pandora.design.patterns.facade.v2;

/**
 * @author Planeswalker23
 */
public class CreateUserFacade {

    private void validateRequired(User user) {
        System.out.println("校验必填");
    }

    private void validateUniqueness(User user) {
        System.out.println("校验唯一性");
    }

    private void preCreate(User user) {
        System.out.println("持久化前置操作，如填充默认字段");
    }

    private int create(User user) {
        System.out.println("持久化操作");
        return 0;
    }

    private void postCreate(User user) {
        System.out.println("持久化后置操作，如手动抛 MQ 消息");
    }

    /**
     * public 类型的可被外部访问的方法
     */
    public int doCreate(User user) {
        this.validateRequired(user);
        this.validateUniqueness(user);
        this.preCreate(user);
        int id = this.create(user);
        this.postCreate(user);
        return id;
    }
}
