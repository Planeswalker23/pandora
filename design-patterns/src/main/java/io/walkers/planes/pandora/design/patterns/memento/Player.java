package io.walkers.planes.pandora.design.patterns.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 玩家
 *
 * @author Planeswalker23
 */
public class Player {

    private List<Memento> mementos;

    public Player(List<Memento> mementos) {
        this.mementos = mementos;
    }

    public List<Memento> createMemento() {
        List<Memento> target = new ArrayList<>();
        for (Memento memento : mementos) {
            target.add(memento);
        }
        return target;
    }

    public void restoreMemento(List<Memento> mementos) {
        this.mementos = mementos;
    }

    @Override
    public String toString() {
        return "Player{" +
                "mementos=" + mementos +
                '}';
    }
}
