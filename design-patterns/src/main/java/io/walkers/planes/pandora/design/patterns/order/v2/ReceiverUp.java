package io.walkers.planes.pandora.design.patterns.order.v2;

/**
 * @author Planeswalker23
 */
public class ReceiverUp implements Receiver{
    @Override
    public void action() {
        System.out.println("方向键UP：角色向上移动一步");
    }
}
