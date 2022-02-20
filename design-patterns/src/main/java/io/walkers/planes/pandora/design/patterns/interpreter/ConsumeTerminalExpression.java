package io.walkers.planes.pandora.design.patterns.interpreter;

/**
 * 累计消费金额解释器，终结符表达式角色
 *
 * @author planeswalker23
 * @date 2022/2/20
 */
public class ConsumeTerminalExpression implements AbstractExpression {
    @Override
    public boolean interpreter(Context info) {
        // 判断用户当前累计消费金额是否大于目标等级的累计消费金额门槛
        return info.getMemberContext().getConsumeAmount() > info.getTargetLevelContext().getConsumeAmount();
    }
}
