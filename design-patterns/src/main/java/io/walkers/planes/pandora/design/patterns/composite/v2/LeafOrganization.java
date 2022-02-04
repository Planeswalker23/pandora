package io.walkers.planes.pandora.design.patterns.composite.v2;

/**
 * 叶子角色：没有子节点的组织
 *
 * @author Planeswalker23
 */
public class LeafOrganization extends Organization {

    public LeafOrganization(String name, String description) {
        super(name, description);
    }

    @Override
    public void add(Organization organization) {
        throw new UnsupportedOperationException("叶子角色不允许操作 add 方法");
    }

    @Override
    public void remove(Organization organization) {
        throw new UnsupportedOperationException("叶子角色不允许操作 remove 方法");
    }

    @Override
    public void getChildren() {
        throw new UnsupportedOperationException("叶子角色不允许操作 getChildrenNumber 方法");
    }
}
