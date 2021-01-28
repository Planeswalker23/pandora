package io.walkers.planes.pandora.design.patterns.factory.abstract_factory;

import io.walkers.planes.pandora.design.patterns.factory.sample_factory.HuaWei;
import io.walkers.planes.pandora.design.patterns.factory.sample_factory.Phone;

/**
 * 新的华为手机工厂类，返回华为手机和FreeBuds对象
 * @author Planeswalker23
 * @date Created in 2019-08-27
 */
public class NewHuaWeiFactory implements NewPhoneFactory {
    @Override
    public Phone getPhone() {
        return new HuaWei();
    }

    @Override
    public HeadSet getHeadSet() {
        return new FreeBuds();
    }
}
