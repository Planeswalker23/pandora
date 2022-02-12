package io.walkers.planes.pandora.design.patterns.memento;

/**
 * 备忘录角色
 *
 * @author Planeswalker23
 */
public class Memento {
    // 精灵名称
    private String name;
    // 精灵生命值
    private Integer hp;
    // 精灵等级
    private String level;
    // 精灵归属人
    private String belonger;

    public Memento(String name, Integer hp, String level, String belonger) {
        this.name = name;
        this.hp = hp;
        this.level = level;
        this.belonger = belonger;
    }

    // 备忘录类内的属性没有 setter 方法，其属性只能在创建备忘录时填入，不应该被外界修改
    public String getName() {
        return name;
    }

    public Integer getHp() {
        return hp;
    }

    public String getLevel() {
        return level;
    }

    public String getBelonger() {
        return belonger;
    }

    @Override
    public String toString() {
        return "Memento{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", level='" + level + '\'' +
                ", belonger='" + belonger + '\'' +
                '}';
    }
}
