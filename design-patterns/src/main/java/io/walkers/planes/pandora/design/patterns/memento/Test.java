package io.walkers.planes.pandora.design.patterns.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Planeswalker23
 */
public class Test {
    public static void main(String[] args) {
        Memento bobo = new Memento("凯西", 10, "Lv3", null);
        Memento fireDragon = new Memento("小火龙", 20, "Lv6", "player1");
        List<Memento> mementos = new ArrayList<>();
        mementos.add(bobo);
        mementos.add(fireDragon);

        Player player = new Player(mementos);
        System.out.println("第一次遇到凯西时的状态: " + player);
        System.out.println("存档");
        List<Memento> mementoCreated = player.createMemento();

        Caretaker caretaker = new Caretaker();
        caretaker.setArchiveMap("1", mementoCreated);

        System.out.println("抓捕失败，凯西逃走，开始读档");
        List<Memento> archive = caretaker.getArchive("1");
        player.restoreMemento(archive);
        System.out.println("读档后的状态: " + player);
    }
}
