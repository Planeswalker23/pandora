package io.walkers.planes.pandora.design.patterns.order.v2;

/**
 * 命令
 *
 * @author Planeswalker23
 */
public class CommandRight extends Command {
    public CommandRight() {
        super(new ReceiverRight(), "方向键RIGHT");
    }
}
