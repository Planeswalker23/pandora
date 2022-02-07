package io.walkers.planes.pandora.design.patterns.state.v2;

/**
 * @author Planeswalker23
 */
public class Test {
    public static void main(String[] args) {
        OrderContext context = new OrderContext();
        context.setState(new UnPaidState());
        System.out.println("-----用户确认订单-----");
        context.handle();
        System.out.println("-----商家发货-----");
        context.handle();
        System.out.println("-----用户确认收货-----");
        context.handle();
    }
}
