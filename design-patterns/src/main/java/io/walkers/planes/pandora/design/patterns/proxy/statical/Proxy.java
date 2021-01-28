package io.walkers.planes.pandora.design.patterns.proxy.statical;

/**
 * 房产中介
 * @author Planeswalker23
 * @date Created in 2020/5/28
 */
public class Proxy implements Subject {

    private House house;

    public Proxy(House house) {
        this.house = house;
    }

    @Override
    public void job() {
        System.out.println("我是中介，我会在数据库中检索，帮助客户找到心仪的房子");
        house.job();
        System.out.println("我是中介，找到了数据库中符合客户需求的方法");
    }

    public static void main(String[] args) {
        // 我可能心仪的房子
        House house = new House();
        // 代理类——房产中介
        Proxy proxy = new Proxy(house);
        // "我"委托中介去寻找房子
        proxy.job();
    }
}
