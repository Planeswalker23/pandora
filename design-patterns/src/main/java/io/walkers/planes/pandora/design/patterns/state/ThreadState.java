package io.walkers.planes.pandora.design.patterns.state;

/**
 * 线程状态抽象类
 * 抽象状态角色：接口或抽象类，负责对象状态定义，并且封装环境角色以实现状态切换。
 * @author Planeswalker23
 * @date Created in 2019-09-16
 */
public abstract class ThreadState {

    /**
     * 环境角色，描述线程此时的状态
     */
    protected ThreadContext threadContext;

    public void setThreadContext(ThreadContext threadContext) {
        this.threadContext = threadContext;
    }

    /**
     * 线程在该状态下的操作
     */
    public abstract void handle();
}
