package io.walkers.planes.pandora.design.patterns.interpreter;

/**
 * 成长值解释器，终结符表达式角色
 *
 * @author planeswalker23
 * @date 2022/2/20
 */
public class ExperienceTerminalExpression implements AbstractExpression {
    @Override
    public boolean interpreter(Context info) {
        // 判断用户当前成长值是否大于目标等级的成长值门槛
        return info.getMemberContext().getExperienceAmount() > info.getTargetLevelContext().getExperienceAmount();
    }
}
