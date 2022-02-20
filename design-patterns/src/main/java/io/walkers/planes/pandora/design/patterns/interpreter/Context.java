package io.walkers.planes.pandora.design.patterns.interpreter;

/**
 * @author planeswalker23
 * @date 2022/2/20
 */
public class Context {
    // 用户上下文
    private MemberContext memberContext;
    // 目标等级上下文
    private TargetLevelContext targetLevelContext;
    // 解释器
    private AbstractExpression expression;

    public Context(MemberContext memberContext, TargetLevelContext targetLevelContext, AbstractExpression expression) {
        this.memberContext = memberContext;
        this.targetLevelContext = targetLevelContext;
        this.expression = expression;
    }

    // 判定方法
    public boolean doOperation() {
        return expression.interpreter(this);
    }

    public MemberContext getMemberContext() {
        return memberContext;
    }

    public void setMemberContext(MemberContext memberContext) {
        this.memberContext = memberContext;
    }

    public TargetLevelContext getTargetLevelContext() {
        return targetLevelContext;
    }

    public void setTargetLevelContext(TargetLevelContext targetLevelContext) {
        this.targetLevelContext = targetLevelContext;
    }

    public AbstractExpression getExpression() {
        return expression;
    }

    public void setExpression(AbstractExpression expression) {
        this.expression = expression;
    }
}
