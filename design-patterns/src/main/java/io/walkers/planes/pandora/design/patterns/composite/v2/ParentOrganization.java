package io.walkers.planes.pandora.design.patterns.composite.v2;

/**
 * 树枝角色：拥有子节点的组织
 *
 * @author Planeswalker23
 */
public class ParentOrganization extends Organization {

    public ParentOrganization(String name, String description) {
        super(name, description);
    }

    @Override
    public void add(Organization organization) {
        this.children.add(organization);
    }

    @Override
    public void remove(Organization organization) {
        this.children.remove(organization);
    }

    @Override
    public void getChildren() {
        for (Organization organization : this.children) {
            if (organization instanceof ParentOrganization) {
                organization.getChildren();
            } else {
                System.out.println(organization);
            }
        }
    }
}
