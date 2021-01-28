package io.walkers.planes.pandora.design.patterns.factory.sample_factory;

/**
 * 手机工厂
 * @author Planeswalker23
 * @date Created in 2019-08-27
 */
public class PhoneFactory {

    /**
     * 根据传入的手机品牌获得手机实体类
     * 简单工厂：根据传入不同的参数创建不同的对象
     * @param brand 手机品牌
     * @return Phone
     */
    public static Phone getPhone(String brand) {
        Phone phone = null;
        if (brand.equalsIgnoreCase("huawei")) {
            phone = new HuaWei();
        } else if (brand.equalsIgnoreCase("iphone")) {
            phone = new IPhone();
        }
        return phone;
    }

    /**
     * 使用反射解决简单工厂每次增加新手机（产品类）都需要改代码的弊端
     * 使得简单工厂不违反开闭原则
     * @param clazz
     * @return Object
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static Object getPhoneClass(Class<? extends Phone> clazz) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return Class.forName(clazz.getName()).newInstance();
    }

    public static void main(String[] args) throws Exception {
        Phone phone = getPhone("huawei");
        phone.takePhotos();

        // 传入的参数需要import或者类的全路径，可以使用配置文件的方式替代
        IPhone iPhone = (IPhone) getPhoneClass(IPhone.class);
        iPhone.takePhotos();
    }
}
