package io.walkers.planes.pandora.design.patterns.composite.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象的组织
 *
 * @author Planeswalker23
 */
public abstract class Organization {
    /**
     * 子节点集合
     */
    protected List<Organization> children = new ArrayList<>();
    /**
     * 组织名称
     */
    private String name;
    /**
     * 组织描述
     */
    private String description;

    public Organization(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // 抽象方法：新增子节点
    public abstract void add(Organization organization);

    // 抽象方法：删除子节点
    public abstract void remove(Organization organization);

    // 抽象方法：获取子节点
    public abstract void getChildren();


    @Override
    public String toString() {
        return "组织名称: " + name + ", 组织描述: " + description;
    }
}
