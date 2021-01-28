## 工厂方法模式
> 工厂方法模式是简单工厂模式的升级版，在工厂方法模式中，为不同的对象提供不同的工厂去创建实例。

### 定义
定义一个用于创建对象的接口，让子类决定将哪一个类实例化。工厂方法模式让一个类的实例化延迟到其子类。

### 实例
> 在上一节的手机实例的基础上，增加工厂接口类`PhoneFactory`，并创建两种品牌的手机工厂类，实现工厂接口。<br>
> `PhoneFactory`抽象工厂：是工厂方法模式的核心，创建对象的工厂类必须实现这个接口。
> `IPhoneFactory、HuaWeiFactory`具体工厂：实现抽象工厂接口的具体工厂类，用来创建某种产品对象。

```java
public interface PhoneFactory {

    /**
     * 获得手机对象的接口方法
     * @return Phone
     */
    Phone getPhone();
}

public class IPhoneFactory implements PhoneFactory {
    @Override
    public Phone getPhone() {
        return new IPhone();
    }
}

public class HuaWeiFactory implements PhoneFactory {
    @Override
    public Phone getPhone() {
        return new HuaWei();
    }
}
```