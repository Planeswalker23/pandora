package io.walkers.planes.pandora.design.patterns.proxy;

/**
 * Proxy代理主题角色
 * @author Planeswalker23
 * @date Created in 2019-09-20
 */
public class Proxy implements Subject {

    /**
     * 要代理的类
     */
    private Subject subject;

    /**
     * 默认代理的类
     */
    public Proxy() {
        this.subject = new RealSubject();
    }

    /**
     * 通过构造函数指定代理类
     * @param subject
     */
    public Proxy(Subject subject) {
        this.subject = subject;
    }

    /**
     * 普通业务方法，找房子
     */
    @Override
    public void request() {
        this.before();
        this.subject.request();
        this.after();
    }

    /**
     * 预处理
     */
    private void before(){
        System.out.println("预处理的业务...");
    }

    /**
     * 善后处理
     */
    private void after(){
        System.out.println("执行完业务后的善后业务...");
    }
}
