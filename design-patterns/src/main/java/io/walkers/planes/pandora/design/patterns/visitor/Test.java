package io.walkers.planes.pandora.design.patterns.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Planeswalker23
 */
public class Test {

    public static void main(String[] args) {
        method2();
    }

    public static void method1() {
        // 定义消息体
        List<Element> elements = new ArrayList<>();
        elements.add(new MessageFromLeader("帮忙看下这个问题"));
        elements.add(new MessageFromWorkmate("帮忙看下这个问题"));

        // 定义访问者
        Visitor laoShiRen = new LaoShiRen();
        Visitor laoYouTiao = new LaoYouTiao();

        // 访问者访问具体元素
        for (Element message : elements) {
            message.accept(laoShiRen);
            message.accept(laoYouTiao);
        }
    }

    public static void method2() {
        // 定义消息体
        List<Element> elements = new ArrayList<>();
        elements.add(new MessageFromLeader("帮忙看下这个问题"));
        elements.add(new MessageFromWorkmate("帮忙看下这个问题"));

        // 定义访问者
        Visitor leader = new Leader();

        // 访问者访问具体元素
        for (Element message : elements) {
            message.accept(leader);
        }
    }
}
