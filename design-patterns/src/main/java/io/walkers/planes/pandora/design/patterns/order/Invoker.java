package io.walkers.planes.pandora.design.patterns.order;

/**
 * 命令调用者:太监，将天子的命令传递给具体执行命令的人
 * @author Planeswalker23
 * @date Created in 2019-09-01
 */
public class Invoker {

    private Command command;

    /**
     * 接收具体的命令
     * @param command
     */
    public void setCommand(Command command) {
        this.command = command;
    }

    /**
     * 执行命令
     */
    public void action(){
        this.command.execute();
    }
}
