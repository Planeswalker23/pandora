package io.walkers.planes.pandora.design.patterns.facade;

/**
 * 游戏机类，里面有两个游戏FIFA19，GTA5
 * facade外观角色
 * @author Planeswalker23
 * @date Created in 2019-09-10
 */
public class Ps4 {

    /**
     * 子系统类
     */
    private Game game;

    public Ps4(Game game) {
        this.game = game;
    }

    /**
     * Ps4开机
     */
    private void openPs4() {
        System.out.println("Ps4开机");
    }

    /**
     * 对外部开启的玩游戏的方法
     */
    public void play() {
        this.openPs4();
        this.game.play();
        System.out.println("开始愉快的玩耍");
    }
}