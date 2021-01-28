package io.walkers.planes.pandora.design.patterns.state;

/**
 * 就绪状态
 * @author Planeswalker23
 * @date Created in 2019-09-18
 */
public class RunnableState extends ThreadState {
    @Override
    public void handle() {
        System.out.println("线程就绪状态，随时可以启动，同时状态转变为运行状态");
        super.threadContext.setThreadState(ThreadContext.RUNNING);
    }
}
