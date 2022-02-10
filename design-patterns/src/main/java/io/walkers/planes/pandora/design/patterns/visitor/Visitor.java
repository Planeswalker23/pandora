package io.walkers.planes.pandora.design.patterns.visitor;

/**
 * @author Planeswalker23
 */
public interface Visitor {

    // 处理主管发来的消息
    void visit(MessageFromLeader message);

    // 处理陌生人发来的消息
    void visit(MessageFromWorkmate message);
}
