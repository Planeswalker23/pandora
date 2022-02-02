package io.walkers.planes.pandora.design.patterns.decorator.v2.conponent;

/**
 * 布丁
 *
 * @author Planeswalker23
 * @date Created in 2022/02/02
 */
public class Pudding extends MilkyTea {

    @Override
    public String material() {
        return "布丁";
    }

    @Override
    public String burden() {
        return "椰果";
    }
}
