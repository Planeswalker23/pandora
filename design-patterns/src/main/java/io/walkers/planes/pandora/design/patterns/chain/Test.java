package io.walkers.planes.pandora.design.patterns.chain;

/**
 * @author Planeswalker23
 */
public class Test {

    public static void main(String[] args) {
        Order order = new Order("DS20220207001", 100, true, false, true);

        Discount platformDiscountCalculator = new PlatformDiscountCalculator();
        Discount redPacketDiscountCalculator = new RedPacketDiscountCalculator();
        Discount shopDiscountCalculator = new ShopDiscountCalculator();

        platformDiscountCalculator.setNext(shopDiscountCalculator);
        shopDiscountCalculator.setNext(redPacketDiscountCalculator);

        platformDiscountCalculator.doCalculate(order);
    }
}
