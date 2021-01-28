package io.walkers.planes.pandora.design.patterns.state;

/**
 * 运行状态
 * @author Planeswalker23
 * @date Created in 2019-09-18
 */
public class RunningState extends ThreadState {

    @Override
    public void handle() {
        System.out.println("线程为运行状态，正在运行，同时转为下一个终止状态");
        super.threadContext.setThreadState(ThreadContext.Terminated);
    }
}
