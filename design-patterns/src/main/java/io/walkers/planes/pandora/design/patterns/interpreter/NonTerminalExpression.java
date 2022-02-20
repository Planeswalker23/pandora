package io.walkers.planes.pandora.design.patterns.interpreter;

/**
 * 非终结符表达式角色
 *
 * @author planeswalker23
 * @date 2022/2/20
 */
public class NonTerminalExpression implements AbstractExpression {

    private AbstractExpression expression1;
    private AbstractExpression expression2;

    public NonTerminalExpression(AbstractExpression expression1, AbstractExpression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpreter(Context info) {
        // 两个条件都满足才返回 true
        return expression1.interpreter(info) && expression2.interpreter(info);
    }
}
