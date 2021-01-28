package io.walkers.planes.pandora.design.patterns.proxy;

/**
 * 具体负责某区域的中介
 * RealSubject具体主题角色：也叫做被委托角色、被代理角色。它才是冤大头，是业务逻辑的具体执行者。<br>
 * @author Planeswalker23
 * @date Created in 2019-09-20
 */
public class RealSubject implements Subject {
    /**
     * 普通业务方法，找房子
     */
    @Override
    public void request() {
        System.out.println("帮我找到杭州某某A区域的房子租…");
    }
}
