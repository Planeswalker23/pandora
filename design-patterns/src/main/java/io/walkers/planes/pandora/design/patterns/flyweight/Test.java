package io.walkers.planes.pandora.design.patterns.flyweight;

/**
 * @author Planeswalker23
 */
public class Test {

    public static void main(String[] args) {
        BaseInfo a = new BaseInfo("A", "大A");
        BaseInfo g = new BaseInfo("G", "小G");

        // 向享元工厂中注册享元角色
        BaseInfoFactory baseInfoFactory = new BaseInfoFactory();
        baseInfoFactory.add(a.getMemberName(), a);
        baseInfoFactory.add(g.getMemberName(), g);

        OrderInfoRepository orderInfoRepository = new OrderInfoRepository();

        // 获取用户大A的信息
        Member member = new Member();
        BaseInfo aBaseInfo = baseInfoFactory.getBaseInfo("A");
        OrderInfo aOrderInfo = orderInfoRepository.getOrderInfoByMember("A");
        member.setBaseInfo(aBaseInfo);
        member.setOrderInfo(aOrderInfo);

        System.out.println(member);
    }
}
