package io.walkers.planes.pandora.design.patterns.interpreter;

/**
 * 目标等级上下文
 *
 * @author planeswalker23
 * @date 2022/2/20
 */
public class TargetLevelContext {
    // 成长值
    private Integer experienceAmount;
    // 累计消费金额
    private Integer consumeAmount;
    // 等级名称
    private String levelName;

    public TargetLevelContext(Integer experienceAmount, Integer consumeAmount, String levelName) {
        this.experienceAmount = experienceAmount;
        this.consumeAmount = consumeAmount;
        this.levelName = levelName;
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

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}
