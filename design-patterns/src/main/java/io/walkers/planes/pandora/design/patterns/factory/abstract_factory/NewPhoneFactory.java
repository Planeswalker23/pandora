package io.walkers.planes.pandora.design.patterns.factory.abstract_factory;

import io.walkers.planes.pandora.design.patterns.factory.sample_factory.Phone;

/**
 * 新的手机工厂接口，包括获得手机方法、获得耳机方法
 * @author Planeswalker23
 * @date Created in 2019-08-27
 */
public interface NewPhoneFactory {

    /**
     * 获得手机对象的接口方法
     * @return Phone
     */
    Phone getPhone();

    /**
     * 获得耳机的接口方法
     * @return
     */
    HeadSet getHeadSet();
}
