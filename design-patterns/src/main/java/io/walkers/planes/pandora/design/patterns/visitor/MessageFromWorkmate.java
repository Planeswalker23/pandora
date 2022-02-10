package io.walkers.planes.pandora.design.patterns.visitor;

/**
 * @author Planeswalker23
 */
public class MessageFromWorkmate extends Element {

    public MessageFromWorkmate(String content) {
        super(content);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
