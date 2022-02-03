package io.walkers.planes.pandora.design.patterns.facade.v2;

/**
 * @author Planeswalker23
 */
public class OldCreateUserController {
    // 依赖注入
    private OldCreateUserService oldCreateUserService;

    // 用户注册
    public int register(User user) {
        oldCreateUserService.validateRequired(user);
        oldCreateUserService.validateUniqueness(user);
        oldCreateUserService.preCreate(user);
        int id = oldCreateUserService.create(user);
        oldCreateUserService.postCreate(user);
        return id;
    }
}
