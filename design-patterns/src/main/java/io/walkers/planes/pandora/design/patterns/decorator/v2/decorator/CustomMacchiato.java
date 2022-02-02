package io.walkers.planes.pandora.design.patterns.decorator.v2.decorator;

import io.walkers.planes.pandora.design.patterns.decorator.v2.conponent.MilkyTea;

/**
 * 自制玛奇朵
 *
 * @author planeswalker23
 */
public class CustomMacchiato extends CustomMilkyTea {

    public CustomMacchiato(MilkyTea milkyTea) {
        super(milkyTea);
    }

    @Override
    public String extra() {
        return "焦糖";
    }
}
