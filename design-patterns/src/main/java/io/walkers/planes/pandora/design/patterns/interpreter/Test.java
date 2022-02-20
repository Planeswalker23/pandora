package io.walkers.planes.pandora.design.patterns.interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author planeswalker23
 * @date 2022/2/20
 */
public class Test {
    public static void main(String[] args) {
        TargetLevelContext level1 = new TargetLevelContext(0, 0,"大众会员");
        TargetLevelContext level2 = new TargetLevelContext(2000, 1000,"黄金会员");
        TargetLevelContext level3 = new TargetLevelContext(6000, 3000,"铂金会员");
        TargetLevelContext level4 = new TargetLevelContext(18000, 9000,"钻石会员");
        // 目标等级列表
        List<TargetLevelContext> levels = new ArrayList<>();
        levels.add(level1);
        levels.add(level2);
        levels.add(level3);
        levels.add(level4);
        // 成长值6800，累计消费2000的会员
        MemberContext memberContext = new MemberContext(6800, 2000);

        // 解释器
        AbstractExpression expression = new NonTerminalExpression(new ExperienceTerminalExpression(), new ConsumeTerminalExpression());

        String levelName = "";
        for (TargetLevelContext levelContext:levels) {
            // 组装上下文，对所有等级进行迭代判定
            Context context = new Context(memberContext, levelContext, expression);
            boolean result = context.doOperation();
            if (result) {
                levelName = levelContext.getLevelName();
            } else {
                break;
            }
        }
        System.out.println("最终判定结果：成长值6800，累计消费2000的会员等级 = " + levelName);
    }
}
