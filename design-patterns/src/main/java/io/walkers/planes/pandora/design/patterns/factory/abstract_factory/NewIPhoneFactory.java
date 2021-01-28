package io.walkers.planes.pandora.design.patterns.factory.abstract_factory;

import io.walkers.planes.pandora.design.patterns.factory.sample_factory.IPhone;
import io.walkers.planes.pandora.design.patterns.factory.sample_factory.Phone;

/**
 * iphone的工厂模式，返回IPhone对象和AirPods对象
 * @author Planeswalker23
 * @date Created in 2019-08-27
 */
public class NewIPhoneFactory implements NewPhoneFactory {
    @Override
    public Phone getPhone() {
        return new IPhone();
    }

    @Override
    public HeadSet getHeadSet() {
        return new AirPods();
    }

    public static void main(String[] args) {
        NewIPhoneFactory iPhoneFactory = new NewIPhoneFactory();
        // 获得手机对象
        Phone iPhone = iPhoneFactory.getPhone();
        iPhone.takePhotos();
        // 获得耳机对象
        HeadSet airPods = iPhoneFactory.getHeadSet();
        airPods.playMusic();
    }
}
