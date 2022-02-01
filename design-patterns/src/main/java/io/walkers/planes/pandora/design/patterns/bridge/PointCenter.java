package io.walkers.planes.pandora.design.patterns.bridge;

/**
 * 积分中心，同步实现类
 *
 * @author planeswalker23
 */
public interface PointCenter {

    /**
     * 发放积分
     *
     * @param userId     用户ID
     * @param pointValue 发放积分值
     */
    void grantPoint(String userId, Long pointValue);
}
