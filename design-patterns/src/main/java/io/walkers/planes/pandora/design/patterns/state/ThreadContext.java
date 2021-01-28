package io.walkers.planes.pandora.design.patterns.state;

/**
 * 环境角色：定义客户端需要的接口，并且负责具体状态的切换。
 * @author Planeswalker23
 * @date Created in 2019-09-17
 */
public class ThreadContext {

    /**
     * 创建状态
     */
    public static final ThreadState START = new StartState();
    /**
     * 就绪状态
     */
    public static final ThreadState RUNNABLE = new RunnableState();
    /**
     * 运行状态
     */
    public static final ThreadState RUNNING = new RunningState();
    /**
     * 终止状态
     */
    public static final ThreadState Terminated = new TerminatedState();

    /**
     * 定义线程此时的状态
     */
    private ThreadState threadState;
    public void setThreadState(ThreadState threadState) {
        this.threadState = threadState;
        this.threadState.setThreadContext(this);
    }

    /**
     * 线程在该状态下的操作
     */
    public void handle() {
        this.threadState.handle();
    }
}
