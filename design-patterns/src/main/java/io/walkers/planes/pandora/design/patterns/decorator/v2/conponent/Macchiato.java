package io.walkers.planes.pandora.design.patterns.decorator.v2.conponent;

/**
 * 玛奇朵
 *
 * @author 范逸东(东稚)
 */
public class Macchiato extends MilkyTea {
    @Override
    public String material() {
        return "玛奇朵";
    }

    @Override
    public String burden() {
        return "波霸";
    }
}
