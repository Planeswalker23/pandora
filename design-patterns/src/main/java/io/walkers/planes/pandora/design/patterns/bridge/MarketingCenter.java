package io.walkers.planes.pandora.design.patterns.bridge;

/**
 * 营销中心
 *
 * @author planeswalker23
 */
public class MarketingCenter {

    private PointCenter pointCenter;

    public MarketingCenter(PointCenter pointCenter) {
        this.pointCenter = pointCenter;
    }

    public static void main(String[] args) {
        SyncPointCenter syncPointCenter = new SyncPointCenter();
        MarketingCenter marketingCenter = new MarketingCenter(syncPointCenter);
        // 注册有礼
        marketingCenter.RegistrationGift("1", 100L);
    }

    /**
     * 注册有礼
     *
     * @param userId     用户ID
     * @param pointValue 发放积分值
     */
    public void RegistrationGift(String userId, Long pointValue) {
        System.out.printf("[营销中心]用户[%s]注册成功，发放奖励积分值[%s]\n", userId, pointValue);
        pointCenter.grantPoint(userId, pointValue);
    }
}
