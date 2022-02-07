package io.walkers.planes.pandora.design.patterns.chain;

/**
 * 平台优惠计算器
 *
 * @author Planeswalker23
 */
public class RedPacketDiscountCalculator extends Discount {

    @Override
    public boolean match(Order order) {
        return order.isSatisfyRedPacketDiscount();
    }

    @Override
    public void calculatePrice(Order order) {
        double price = order.getPaidPrice() == null ? order.getPrice() : order.getPaidPrice();
        price = price - 5;
        order.setPaidPrice(price);
        System.out.printf("订单[%s]满足红包优惠，便宜5元，计算完成后价格为[%s]\n", order.getCode(), order.getPaidPrice());
    }
}
