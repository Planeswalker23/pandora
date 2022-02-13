package io.walkers.planes.pandora.design.patterns.order.v2;

/**
 * @author Planeswalker23
 * @date Created in 2019-09-01
 */
public class Test {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        System.out.println("玩家按下方向键UP");
        invoker.setCommand(new CommandUp());
        invoker.executeCommand();

        System.out.println("玩家按下方向键DOWN");
        invoker.setCommand(new CommandDown());
        invoker.executeCommand();

        System.out.println("玩家按下方向键LEFT");
        invoker.setCommand(new CommandLeft());
        invoker.executeCommand();

        System.out.println("玩家按下方向键RIGHT");
        invoker.setCommand(new CommandRight());
        invoker.executeCommand();
    }
}