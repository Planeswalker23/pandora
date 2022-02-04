package io.walkers.planes.pandora.design.patterns.flyweight;

/**
 * @author 范逸东(东稚)
 */
public class OrderInfoRepository {

    public OrderInfo getOrderInfoByMember(String memberName) {
        System.out.println("从数据库中获取用户[" + memberName + "]的各状态订单数量");
        return new OrderInfo(0, 0, 0, 0);
    }
}
