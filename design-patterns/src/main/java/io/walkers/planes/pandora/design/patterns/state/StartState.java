package io.walkers.planes.pandora.design.patterns.state;

/**
 * 线程刚创建的状态
 * @author Planeswalker23
 * @date Created in 2019-09-18
 */
public class StartState extends ThreadState {

    @Override
    public void handle() {
        System.out.println("线程创建，调用start()方法，状态转变为就绪状态");
        // 设置环境对象的状态为下一个就绪状态
        super.threadContext.setThreadState(ThreadContext.RUNNABLE);
    }
}
