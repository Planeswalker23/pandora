package io.walkers.planes.pandora.design.patterns.order.v2;

/**
 * @author Planeswalker23
 */
public class ReceiverRight implements Receiver{
    @Override
    public void action() {
        System.out.println("方向键RIGHT：角色向右移动一步");
    }
}
