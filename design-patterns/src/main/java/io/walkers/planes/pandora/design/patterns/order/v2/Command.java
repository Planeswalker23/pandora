package io.walkers.planes.pandora.design.patterns.order.v2;

/**
 * 命令
 *
 * @author Planeswalker23
 */
public abstract class Command {

    private Receiver receiver;
    private String name;

    public Command(Receiver receiver, String name) {
        this.receiver = receiver;
        this.name = name;
    }

    public void execute() {
        receiver.action();
    }
}
