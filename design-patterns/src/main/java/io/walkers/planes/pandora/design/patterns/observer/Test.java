package io.walkers.planes.pandora.design.patterns.observer;

/**
 * 测试类
 * @author Planeswalker23
 * @date Created in 2019-08-31
 */
public class Test {

    public static void main(String[] args) {
        // 创建巨星对象
        SuperStar superStar = new SuperStar();
        superStar.send("这是我的第一条微博，但是现在关注为0，没有人收到");
        // 创建第一个用户，关注巨星
        UserA lonelyWolf = new UserA("孤独的狼");
        superStar.add(lonelyWolf);
        superStar.send("2. 你好" + lonelyWolf.getUserName());
        // 创建第二个用户，关注巨星
        UserB sheep = new UserB("寂寞的羊");
        superStar.add(sheep);
        superStar.send("2、欢迎新同学");
        // 第二个用户取关
        superStar.delete(sheep);
        superStar.send("3、床前明月光，你走吧");
    }
}
