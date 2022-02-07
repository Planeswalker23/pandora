package io.walkers.planes.pandora.design.patterns.state.v2;

/**
 * @author Planeswalker23
 */
public abstract class OrderState {

    private OrderContext context;

    public OrderContext getContext() {
        return context;
    }

    public void setContext(OrderContext context) {
        this.context = context;
    }

    // 订单在指定状态下，系统执行的业务
    public abstract void handle();
}
