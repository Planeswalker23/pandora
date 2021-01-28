package io.walkers.planes.pandora.design.patterns.state;

/**
 * 测试类
 * @author Planeswalker23
 * @date Created in 2019-08-30
 */
public class Test {

    public static void main(String[] args) {
        ThreadContext threadContext = new ThreadContext();
        threadContext.setThreadState(new StartState());
        threadContext.handle();
        threadContext.handle();
        threadContext.handle();
        threadContext.handle();
    }
}
