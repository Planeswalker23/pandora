package io.walkers.planes.pandora.design.patterns.state.v2;

/**
 * @author Planeswalker23
 */
public class OrderContext {

    private OrderState state;

    public void setState(OrderState state) {
        this.state = state;
        this.state.setContext(this);
    }

    public void handle() {
        // 执行该状态下的业务逻辑
        this.state.handle();
    }
}
