package io.walkers.planes.pandora.design.patterns.order.v2;

/**
 * 命令
 *
 * @author Planeswalker23
 */
public class CommandLeft extends Command {
    public CommandLeft() {
        super(new ReceiverLeft(), "方向键LEFT");
    }
}
