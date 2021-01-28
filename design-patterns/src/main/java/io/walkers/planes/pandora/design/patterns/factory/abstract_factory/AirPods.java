package io.walkers.planes.pandora.design.patterns.factory.abstract_factory;

/**
 * 苹果耳机实体类
 * @author Planeswalker23
 * @date Created in 2019-08-27
 */
public class AirPods implements HeadSet {
    @Override
    public void playMusic() {
        System.out.println("AirPods...好像还挺好用？");
    }
}
