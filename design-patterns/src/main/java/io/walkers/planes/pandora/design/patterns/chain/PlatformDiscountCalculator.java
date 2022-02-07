package io.walkers.planes.pandora.design.patterns.chain;

/**
 * 平台优惠计算器
 *
 * @author Planeswalker23
 */
public class PlatformDiscountCalculator extends Discount {

    @Override
    public boolean match(Order order) {
        return order.isSatisfyPlatformDiscount();
    }

    @Override
    public void calculatePrice(Order order) {
        double price = order.getPaidPrice() == null ? order.getPrice() : order.getPaidPrice();
        price = price - 20;
        order.setPaidPrice(price);
        System.out.printf("订单[%s]满足平台优惠，便宜20元，计算完成后价格为[%s]\n", order.getCode(), order.getPaidPrice());
    }
}
