package io.walkers.planes.pandora.design.patterns.factory.factory_method;

import io.walkers.planes.pandora.design.patterns.factory.sample_factory.Phone;

/**
 * @author planeswalker23
 * @date 2022/1/18
 */
public class XiaoMi implements Phone {
    /**
     * 每只手机都拥有的功能，如拍照
     */
    @Override
    public void takePhotos() {
        System.out.println("小米手机，就是牛");
    }
}
