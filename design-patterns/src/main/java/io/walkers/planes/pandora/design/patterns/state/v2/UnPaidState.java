package io.walkers.planes.pandora.design.patterns.state.v2;

/**
 * @author Planeswalker23
 */
public class UnPaidState extends OrderState {

    @Override
    public void handle() {
        System.out.println("当前订单状态为[待支付]");
        System.out.println("用户支付成功");
        super.getContext().setState(new UnDeliverState());
        System.out.println("当前订单状态为[待发货]");
    }
}
