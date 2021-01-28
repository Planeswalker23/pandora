## 简单工厂模式
> 简单工程模式并不属于Gof23种设计模式，只能算工厂模式的一种实现方法，因为它违背了设计模式六大原则的开放-封闭原则，因为每次添加一个产品类都需要在获取实例的方法中修改代码。<br>
> 开放-封闭原则：`一个软件实体如类、模块和函数应该对扩展开放，对修改关闭。即一个软件实体应该通过扩展来实现变化，而不是通过修改已有的代码来实现变化。`

### 定义
创建一个工厂类，可以根据传入参数不同获取不同的实例。

### 适用场景
1. 需要创建的对象较少
2. 客户端不关心对象的创建过程

### 实例
> 现在创建一个获取手机的工厂，每个手机有一个拍照的功能。

1. 首先创建手机的公共接口（抽象产品：负责描述所有实例所共有的公共接口）
````java
public interface Phone {

    /**
     * 每只手机都拥有的功能，如拍照
     */
    void takePhotos();
}
````

2. 创建两个手机类，实现Phone公共接口（具体产品：简单工厂创建的对象，需要实现抽象产品）
````java
public class IPhone implements Phone {
    @Override
    public void takePhotos() {
        System.out.println("IPhone...魔鬼前置");
    }
}

public class HuaWei implements Phone {
    @Override
    public void takePhotos() {
        System.out.println("华为...也能照亮你的美");
    }
}
````

3. 创建工厂类，它有一个public方法，可根据传入的手机品牌获得不同的手机实体类
````java
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

    public static void main(String[] args) throws Exception {
        Phone phone = getPhone("huawei");
        phone.takePhotos();
    }
}
````

### 使用反射机制改善简单工厂，使得简单工厂不违反开闭原则
````java
public class PhoneFactory {

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
        // 传入的参数需要import或者类的全路径，可以使用配置文件的方式替代
        IPhone iPhone = (IPhone) getPhoneClass(IPhone.class);
        iPhone.takePhotos();
    }
}
````
- 获取产品类方法的入参需要import或者类的全路径，可以使用配置文件的方式替代