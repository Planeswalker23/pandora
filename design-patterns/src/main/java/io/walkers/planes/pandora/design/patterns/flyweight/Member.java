package io.walkers.planes.pandora.design.patterns.flyweight;

/**
 * 会员
 *
 * @author 范逸东(东稚)
 */
public class Member {
    // 会员基础信息-享元角色
    private BaseInfo baseInfo;
    // 会员订单数-非享元角色
    private OrderInfo orderInfo;

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    @Override
    public String toString() {
        return "会员{" +
                "基础信息=" + baseInfo +
                ", 订单信息=" + orderInfo +
                '}';
    }
}
