package io.walkers.planes.pandora.design.patterns.bridge;

/**
 * 积分中心，异步实现类
 *
 * @author planeswalker23
 */
public class AsyncPointCenter implements PointCenter {

    @Override
    public void grantPoint(String userId, Long pointValue) {
        System.out.printf("[异步积分中心实现类]用户[%s]发放积分值[%s]\n", userId, pointValue);
    }
}
