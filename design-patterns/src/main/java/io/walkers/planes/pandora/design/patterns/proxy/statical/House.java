package io.walkers.planes.pandora.design.patterns.proxy.statical;

/**
 * 房产中介的客户
 * @author Planeswalker23
 * @date Created in 2020/5/28
 */
public class House implements Subject {

    @Override
    public void job() {
        System.out.println("我是客户想要的房子，通过 job 方法注册在数据库中");
    }
}
