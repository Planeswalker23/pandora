package io.walkers.planes.pandora.design.patterns.factory.factory_method;

import io.walkers.planes.pandora.design.patterns.factory.sample_factory.IPhone;
import io.walkers.planes.pandora.design.patterns.factory.sample_factory.Phone;

/**
 * @author Planeswalker23
 * @date Created in 2019-08-27
 */
public class IPhoneFactory implements PhoneFactory {
    @Override
    public Phone getPhone() {
        return new IPhone();
    }

    public static void main(String[] args) {
        PhoneFactory factory = new IPhoneFactory();
        Phone iphone = factory.getPhone();
        iphone.takePhotos();
    }
}
