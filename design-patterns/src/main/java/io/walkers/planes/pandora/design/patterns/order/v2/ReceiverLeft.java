package io.walkers.planes.pandora.design.patterns.order.v2;

/**
 * @author Planeswalker23
 */
public class ReceiverLeft implements Receiver{
    @Override
    public void action() {
        System.out.println("方向键LEFT：角色向左移动一步");
    }
}
