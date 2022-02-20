package io.walkers.planes.pandora.design.patterns.interpreter;

/**
 * @author planeswalker23
 * @date 2022/2/20
 */
public class MemberContext {
    // 成长值
    private Integer experienceAmount;
    // 累计消费金额
    private Integer consumeAmount;

    public MemberContext(Integer experienceAmount, Integer consumeAmount) {
        this.experienceAmount = experienceAmount;
        this.consumeAmount = consumeAmount;
    }

    public Integer getExperienceAmount() {
        return experienceAmount;
    }

    public void setExperienceAmount(Integer experienceAmount) {
        this.experienceAmount = experienceAmount;
    }

    public Integer getConsumeAmount() {
        return consumeAmount;
    }

    public void setConsumeAmount(Integer consumeAmount) {
        this.consumeAmount = consumeAmount;
    }
}
