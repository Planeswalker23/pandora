package io.walkers.planes.pandora.design.patterns.visitor;

/**
 * @author Planeswalker23
 */
public class Leader implements Visitor {
    @Override
    public void visit(MessageFromLeader message) {
        System.out.printf("主管收到主管发来的消息[%s], 响应是：好的，我马上看。\n", message.getContent());
    }

    @Override
    public void visit(MessageFromWorkmate message) {
        System.out.printf("老油条收到同事发来的消息[%s], 响应是：未读/你找一下LaoShiRen\n", message.getContent());
    }
}
