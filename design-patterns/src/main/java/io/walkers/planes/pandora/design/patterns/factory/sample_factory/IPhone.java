package io.walkers.planes.pandora.design.patterns.factory.sample_factory;

/**
 * IPhone手机
 * @author Planeswalker23
 * @date Created in 2019-08-27
 */
public class IPhone implements Phone {
    @Override
    public void takePhotos() {
        System.out.println("IPhone...魔鬼前置");
    }
}
