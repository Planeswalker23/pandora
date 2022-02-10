package io.walkers.planes.pandora.design.patterns.visitor;

/**
 * @author Planeswalker23
 */
public class LaoShiRen implements Visitor {
    @Override
    public void visit(MessageFromLeader message) {
        System.out.printf("老实人收到主管发来的消息[%s], 响应是：好的，我一会就看。\n", message.getContent());
    }

    @Override
    public void visit(MessageFromWorkmate message) {
        System.out.printf("老实人收到同事发来的消息[%s], 响应是：好的，我一会就看。\n", message.getContent());
    }
}
