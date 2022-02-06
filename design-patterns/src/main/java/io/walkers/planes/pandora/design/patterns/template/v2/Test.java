package io.walkers.planes.pandora.design.patterns.template.v2;

/**
 * @author Planeswalker23
 */
public class Test {

    public static void main(String[] args) {
        CreateUserService createUserService = new CreateUserService();
        createUserService.doCreate(new User());

        CreateMemberService createMemberService = new CreateMemberService();
        createMemberService.doCreate(new Member());
    }
}
