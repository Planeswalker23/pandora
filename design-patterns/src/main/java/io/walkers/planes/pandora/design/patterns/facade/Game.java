package io.walkers.planes.pandora.design.patterns.facade;

/**
 * subsystem子系统角色
 * @author Planeswalker23
 * @date Created in 2019-09-11
 */
public class Game {

    private String name;

    public Game(String name) {
        this.name = name;
    }

    public void play() {
        System.out.println("选择游戏" + this.name);
    }
}
