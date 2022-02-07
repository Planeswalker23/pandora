package io.walkers.planes.pandora.design.patterns.chain;

/**
 * 商品
 *
 * @author Planeswalker23
 */
public class Order {
    // 订单码
    private String code;
    // 价格
    private double price;
    // 支付价格
    private Double paidPrice;
    // 满足平台优惠
    private boolean satisfyPlatformDiscount;
    // 满足店铺优惠
    private boolean satisfyShopDiscount;
    // 满足红包优惠
    private boolean satisfyRedPacketDiscount;

    public Order(String code, double price, boolean satisfyPlatformDiscount, boolean satisfyShopDiscount, boolean satisfyRedPacketDiscount) {
        this.code = code;
        this.price = price;
        this.satisfyPlatformDiscount = satisfyPlatformDiscount;
        this.satisfyShopDiscount = satisfyShopDiscount;
        this.satisfyRedPacketDiscount = satisfyRedPacketDiscount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Double getPaidPrice() {
        return paidPrice;
    }

    public void setPaidPrice(Double paidPrice) {
        this.paidPrice = paidPrice;
    }

    public boolean isSatisfyPlatformDiscount() {
        return satisfyPlatformDiscount;
    }

    public void setSatisfyPlatformDiscount(boolean satisfyPlatformDiscount) {
        this.satisfyPlatformDiscount = satisfyPlatformDiscount;
    }

    public boolean isSatisfyShopDiscount() {
        return satisfyShopDiscount;
    }

    public void setSatisfyShopDiscount(boolean satisfyShopDiscount) {
        this.satisfyShopDiscount = satisfyShopDiscount;
    }

    public boolean isSatisfyRedPacketDiscount() {
        return satisfyRedPacketDiscount;
    }

    public void setSatisfyRedPacketDiscount(boolean satisfyRedPacketDiscount) {
        this.satisfyRedPacketDiscount = satisfyRedPacketDiscount;
    }
}
