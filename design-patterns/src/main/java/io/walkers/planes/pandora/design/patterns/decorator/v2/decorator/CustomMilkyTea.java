package io.walkers.planes.pandora.design.patterns.decorator.v2.decorator;

import io.walkers.planes.pandora.design.patterns.decorator.v2.conponent.MilkyTea;

/**
 * PlanesWalker 自制奶茶
 *
 * @author planeswalker23
 */
public abstract class CustomMilkyTea {

    private MilkyTea milkyTea;

    public CustomMilkyTea(MilkyTea milkyTea) {
        this.milkyTea = milkyTea;
    }

    public abstract String extra();

    /**
     * 扩展其功能
     *
     * @return
     */
    public String description() {
        return "自制" + this.extra() + milkyTea.description();
    }
}
