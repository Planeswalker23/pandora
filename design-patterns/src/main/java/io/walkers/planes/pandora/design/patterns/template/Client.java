package io.walkers.planes.pandora.design.patterns.template;

/**
 * 业务验收测试类
 * @author Planeswalker23
 * @date Created in 2019-08-18
 */
public class Client {

    public static void main(String[] args) {
        Hummer hummer = new Hummer();
        hummer.run();

        Benz benz = new Benz();
        benz.run();
    }
}
