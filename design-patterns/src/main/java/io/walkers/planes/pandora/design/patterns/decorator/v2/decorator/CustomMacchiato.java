package io.walkers.planes.pandora.design.patterns.decorator.v2.decorator;

import io.walkers.planes.pandora.design.patterns.decorator.v2.conponent.MilkyTea;

/**
 * 自制玛奇朵
 *
 * @author 范逸东(东稚)
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
