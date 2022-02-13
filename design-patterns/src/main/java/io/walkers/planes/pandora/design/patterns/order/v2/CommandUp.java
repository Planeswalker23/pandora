package io.walkers.planes.pandora.design.patterns.order.v2;

/**
 * 命令
 *
 * @author Planeswalker23
 */
public class CommandUp extends Command {
    public CommandUp() {
        super(new ReceiverUp(), "方向键UP");
    }
}
