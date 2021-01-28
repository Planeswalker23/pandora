package io.walkers.planes.pandora.design.patterns.order;

/**
 * @author Planeswalker23
 * @date Created in 2019-09-01
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("我按下播放按钮");
        // 定义接收者
        Receiver receiver = new Play();
        Command command = new PauseButton(receiver);
        // 声明调用者taiJian
        Invoker me = new Invoker();
        // 将命令交给调用者执行
        me.setCommand(command);
        me.action();

        System.out.println("我准备按下播放按钮");
        Receiver newReceiver = new Pause();
        Command newCommand = new PauseButton(newReceiver);
        System.out.println("但仔细想想，又改按了暂停按钮");
        me.setCommand(newCommand);
        me.action();
    }
}
