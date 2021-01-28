## 抽象工厂模式
> 抽象工厂模式是工厂方法模式的升级版，在抽象工厂模式中，抽象工厂接口有若干个方法需要具体工厂类实现。换言之，抽象工厂模式中的工厂类可以创建多个对象（着多个对象没有继承、实现接口的关系）

### 定义
提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。（在抽象工厂模式中，每一个具体工厂都提供了多个工厂方法用于产生多种不同类型的对象）

### 实例
1. 创建一个耳机接口，表明这是工厂生产手机的配件。
````java
public interface HeadSet {

    /**
     * 耳机有播放音乐的功能
     */
    void playMusic();
}
````

2. 创建`IPhone`和`HuaWei`对象分别对应的耳机配件——`AirPods`和`FreeBuds`，实现`HeadSet`耳机接口
````java
public class AirPods implements HeadSet {
    @Override
    public void playMusic() {
        System.out.println("AirPods...好像还挺好用？");
    }
}

public class FreeBuds implements HeadSet {
    @Override
    public void playMusic() {
        System.out.println("华为蓝牙耳机...好像丑一点？");
    }
}
````

3. 创建新的工厂接口，包含获得手机和获得耳机两个方法。
````java
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
````

4. 创建两个新的手机工厂类，实现新的工厂接口
````java
public class NewIPhoneFactory implements NewPhoneFactory {
    @Override
    public Phone getPhone() {
        return new IPhone();
    }

    @Override
    public HeadSet getHeadSet() {
        return new AirPods();
    }
}

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
````

5. 测试代码如下
````$xslt
public static void main(String[] args) {
    NewIPhoneFactory iPhoneFactory = new NewIPhoneFactory();
    // 获得手机对象
    Phone iPhone = iPhoneFactory.getPhone();
    iPhone.takePhotos();
    // 获得耳机对象
    HeadSet airPods = iPhoneFactory.getHeadSet();
    airPods.playMusic();
}
````