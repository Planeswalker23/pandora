package io.walkers.planes.pandora.design.patterns.factory.factory_method;

import io.walkers.planes.pandora.design.patterns.factory.sample_factory.Phone;

/**
 * @author planeswalker23
 * @date 2022/1/18
 */
public class XiaoMiFactory implements PhoneFactory{
    /**
     * 获得手机对象的接口方法
     *
     * @return Phone
     */
    @Override
    public Phone getPhone() {
        return new XiaoMi();
    }
}
