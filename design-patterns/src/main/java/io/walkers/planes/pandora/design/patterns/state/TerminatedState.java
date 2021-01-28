package io.walkers.planes.pandora.design.patterns.state;

/**
 * 终止状态
 * @author Planeswalker23
 * @date Created in 2019-09-18
 */
public class TerminatedState extends ThreadState {
    @Override
    public void handle() {
        System.out.println("线程已终止");
    }
}
