package io.walkers.planes.pandora.design.patterns.facade.v2;

/**
 * @author Planeswalker23
 */
public class OldCreateUserService {

    public void validateRequired(User user) {
        System.out.println("OldCreateUserService-校验必填");
    }

    public void validateUniqueness(User user) {
        System.out.println("OldCreateUserService-校验唯一性");
    }

    public void preCreate(User user) {
        System.out.println("OldCreateUserService-持久化前置操作，如填充默认字段");
    }

    public int create(User user) {
        System.out.println("OldCreateUserService-持久化操作");
        return 0;
    }

    public void postCreate(User user) {
        System.out.println("OldCreateUserService-持久化后置操作，如手动抛 MQ 消息");
    }
}
