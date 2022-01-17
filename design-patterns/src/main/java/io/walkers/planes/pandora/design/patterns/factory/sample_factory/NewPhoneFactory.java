package io.walkers.planes.pandora.design.patterns.factory.sample_factory;

/**
 * 优化后的手机工厂
 *
 * @author Planeswalker23
 */
public class NewPhoneFactory {

    /**
     * 使用反射解决简单工厂每次增加新手机（产品类）都需要改代码的弊端，使得简单工厂不违反开闭原则
     *
     * @param clazz
     * @return Object
     */
    public static Object getPhoneClass(Class<? extends Phone> clazz) {
        try {
            return Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.out.println("创建具体产品类失败，具体原因为：");
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        // 传入的参数需要import或者类的全路径，可以使用配置文件的方式替代
        IPhone iPhone = (IPhone) getPhoneClass(IPhone.class);
        iPhone.takePhotos();
    }
}
