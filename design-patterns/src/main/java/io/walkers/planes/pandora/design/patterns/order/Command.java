package io.walkers.planes.pandora.design.patterns.order;

/**
 * 命令抽象类
 * @author Planeswalker23
 * @date Created in 2019-09-01
 */
public abstract class Command {

    /**
     * 每个命令类需要实现一个执行命令的具体方法
     */
    public abstract void execute();
}
