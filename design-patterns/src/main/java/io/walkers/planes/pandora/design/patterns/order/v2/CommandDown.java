package io.walkers.planes.pandora.design.patterns.order.v2;

/**
 * 命令
 *
 * @author Planeswalker23
 */
public class CommandDown extends Command {
    public CommandDown() {
        super(new ReceiverDown(), "方向键DOWN");
    }
}
