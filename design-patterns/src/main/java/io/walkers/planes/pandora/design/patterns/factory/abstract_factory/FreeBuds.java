package io.walkers.planes.pandora.design.patterns.factory.abstract_factory;

/**
 * 华为蓝牙耳机
 * @author Planeswalker23
 * @date Created in 2019-08-27
 */
public class FreeBuds implements HeadSet {
    @Override
    public void playMusic() {
        System.out.println("华为蓝牙耳机...好像丑一点？");
    }
}
