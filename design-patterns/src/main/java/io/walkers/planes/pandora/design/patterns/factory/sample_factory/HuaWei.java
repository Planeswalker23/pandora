package io.walkers.planes.pandora.design.patterns.factory.sample_factory;

/**
 * 华为手机
 * @author Planeswalker23
 * @date Created in 2019-08-27
 */
public class HuaWei implements Phone {
    @Override
    public void takePhotos() {
        System.out.println("华为...也能照亮你的美");
    }
}
