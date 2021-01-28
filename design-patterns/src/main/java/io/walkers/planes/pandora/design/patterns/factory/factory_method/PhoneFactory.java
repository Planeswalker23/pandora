package io.walkers.planes.pandora.design.patterns.factory.factory_method;

import io.walkers.planes.pandora.design.patterns.factory.sample_factory.Phone;

/**
 * 工厂接口
 * @author Planeswalker23
 * @date Created in 2019-08-27
 */
public interface PhoneFactory {

    /**
     * 获得手机对象的接口方法
     * @return Phone
     */
    Phone getPhone();
}
