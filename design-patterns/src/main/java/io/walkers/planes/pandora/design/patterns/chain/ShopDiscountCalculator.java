package io.walkers.planes.pandora.design.patterns.chain;

/**
 * 平台优惠计算器
 *
 * @author Planeswalker23
 */
public class ShopDiscountCalculator extends Discount {

    @Override
    public boolean match(Order order) {
        return order.isSatisfyShopDiscount();
    }

    @Override
    public void calculatePrice(Order order) {
        double price = order.getPaidPrice() == null ? order.getPrice() : order.getPaidPrice();
        price = price - 10;
        order.setPaidPrice(price);
        System.out.printf("订单[%s]满足店铺优惠，便宜10元，计算完成后价格为[%s]\n", order.getCode(), order.getPaidPrice());
    }
}
