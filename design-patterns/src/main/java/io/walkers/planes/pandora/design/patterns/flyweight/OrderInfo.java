package io.walkers.planes.pandora.design.patterns.flyweight;

/**
 * 订单信息
 *
 * @author Planeswalker23
 */
public class OrderInfo {
    // 待付款订单数
    private Integer unPaidOrderCount;
    // 待发货订单数
    private Integer unDeliverOrderCount;
    // 待收货订单数
    private Integer unReceiveOrderCount;
    // 待评价订单数
    private Integer unEvaluateOrderCount;

    public OrderInfo(Integer unPaidOrderCount, Integer unDeliverOrderCount, Integer unReceiveOrderCount, Integer unEvaluateOrderCount) {
        this.unPaidOrderCount = unPaidOrderCount;
        this.unDeliverOrderCount = unDeliverOrderCount;
        this.unReceiveOrderCount = unReceiveOrderCount;
        this.unEvaluateOrderCount = unEvaluateOrderCount;
    }

    @Override
    public String toString() {
        return "{" +
                "待付款订单数=" + unPaidOrderCount +
                ", 待发货订单数=" + unDeliverOrderCount +
                ", 待收货订单数=" + unReceiveOrderCount +
                ", 待评价订单数=" + unEvaluateOrderCount +
                '}';
    }

    public Integer getUnPaidOrderCount() {
        return unPaidOrderCount;
    }

    public void setUnPaidOrderCount(Integer unPaidOrderCount) {
        this.unPaidOrderCount = unPaidOrderCount;
    }

    public Integer getUnDeliverOrderCount() {
        return unDeliverOrderCount;
    }

    public void setUnDeliverOrderCount(Integer unDeliverOrderCount) {
        this.unDeliverOrderCount = unDeliverOrderCount;
    }

    public Integer getUnReceiveOrderCount() {
        return unReceiveOrderCount;
    }

    public void setUnReceiveOrderCount(Integer unReceiveOrderCount) {
        this.unReceiveOrderCount = unReceiveOrderCount;
    }

    public Integer getUnEvaluateOrderCount() {
        return unEvaluateOrderCount;
    }

    public void setUnEvaluateOrderCount(Integer unEvaluateOrderCount) {
        this.unEvaluateOrderCount = unEvaluateOrderCount;
    }
}
