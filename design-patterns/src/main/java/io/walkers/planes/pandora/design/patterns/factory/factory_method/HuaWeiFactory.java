package io.walkers.planes.pandora.design.patterns.factory.factory_method;

import io.walkers.planes.pandora.design.patterns.factory.sample_factory.HuaWei;
import io.walkers.planes.pandora.design.patterns.factory.sample_factory.Phone;

/**
 * @author Planeswalker23
 * @date Created in 2019-08-27
 */
public class HuaWeiFactory implements PhoneFactory {
    @Override
    public Phone getPhone() {
        return new HuaWei();
    }

    public static void main(String[] args) {
        PhoneFactory factory = new HuaWeiFactory();
        Phone huawei = factory.getPhone();
        huawei.takePhotos();
    }
}
