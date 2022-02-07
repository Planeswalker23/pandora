package io.walkers.planes.pandora.design.patterns.state.v2;

/**
 * @author Planeswalker23
 */
public class UnDeliverState extends OrderState {

    @Override
    public void handle() {
        System.out.println("当前订单状态为[待发货]");
        System.out.println("商家发货成功");
        super.getContext().setState(new UnReceiveState());
        System.out.println("当前订单状态为[待收货]");
    }
}
