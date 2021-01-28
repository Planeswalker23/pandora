package io.walkers.planes.pandora.design.patterns.proxy;

/**
 * 自如中介，每个自如的中介都需要实现一个找房子的方法。
 * Subject抽象主题角色：抽象主题类可以是抽象类也可以是接口，是一个最普通的业务类型定义，无特殊要求。<br>
 * @author Planeswalker23
 * @date Created in 2019-09-20
 */
public interface Subject {

    /**
     * 普通业务方法，找房子
     */
    void request();
}
