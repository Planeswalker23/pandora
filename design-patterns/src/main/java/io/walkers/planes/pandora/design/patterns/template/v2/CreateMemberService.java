package io.walkers.planes.pandora.design.patterns.template.v2;

/**
 * @author Planeswalker23
 */
public class CreateMemberService implements BaseCreateService<Member> {
    @Override
    public void validate(Member member) {
        System.out.println("执行Member模型校验方法");
    }

    @Override
    public void fill(Member member) {
        System.out.println("执行Member模型填充方法");
    }

    @Override
    public int create(Member member) {
        System.out.println("执行Member模型持久化方法");
        return 0;
    }
}
