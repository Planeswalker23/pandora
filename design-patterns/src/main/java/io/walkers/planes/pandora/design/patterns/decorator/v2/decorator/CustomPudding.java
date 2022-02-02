package io.walkers.planes.pandora.design.patterns.decorator.v2.decorator;

import io.walkers.planes.pandora.design.patterns.decorator.v2.conponent.MilkyTea;

/**
 * 自定义的布丁奶茶
 *
 * @author Planeswalker23
 * @date Created in 2022/02/02
 */
public class CustomPudding extends CustomMilkyTea {

    public CustomPudding(MilkyTea milkyTea) {
        super(milkyTea);
    }

    @Override
    public String extra() {
        return "烧仙草";
    }
}
