package io.walkers.planes.pandora.design.patterns.order;

/**
 * 具体的命令类:按下遥控机的播放键
 * @author Planeswalker23
 * @date Created in 2019-09-01
 */
public class PlayButton extends Command {

    private Receiver receiver;

    public PlayButton(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("按下遥控机的播放键");
        this.receiver.plan();
    }
}
