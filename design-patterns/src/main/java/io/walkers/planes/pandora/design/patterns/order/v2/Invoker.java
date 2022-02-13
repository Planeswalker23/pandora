package io.walkers.planes.pandora.design.patterns.order.v2;

/**
 * @author Planeswalker23
 */
public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        this.command.execute();
    }
}
