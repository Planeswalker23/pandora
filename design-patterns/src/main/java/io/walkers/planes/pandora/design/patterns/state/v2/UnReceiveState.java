package io.walkers.planes.pandora.design.patterns.state.v2;

/**
 * @author Planeswalker23
 */
public class UnReceiveState extends OrderState {

    @Override
    public void handle() {
        System.out.println("当前订单状态为[待收货]");
        System.out.println("用户确认收货");
        System.out.println("当前订单状态为[已完成]");
    }
}
