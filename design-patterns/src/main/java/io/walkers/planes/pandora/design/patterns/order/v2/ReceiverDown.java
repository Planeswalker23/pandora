package io.walkers.planes.pandora.design.patterns.order.v2;

/**
 * @author Planeswalker23
 */
public class ReceiverDown implements Receiver{
    @Override
    public void action() {
        System.out.println("方向键DOWN：角色向下移动一步");
    }
}
