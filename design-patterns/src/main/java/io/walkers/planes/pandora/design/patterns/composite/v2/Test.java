package io.walkers.planes.pandora.design.patterns.composite.v2;

/**
 * @author Planeswalker23
 * @date Created in 2019-09-16
 */
public class Test {
    public static void main(String[] args) {
        Organization company = new ParentOrganization("设计模式控股公司", "专职研究设计模式的互联网公司");

        Organization humanResource = new ParentOrganization("人力资源部", "负责管理公司人员");
        Organization hr = new LeafOrganization("HR部", "负责招聘");
        Organization administration = new LeafOrganization("行政部", "负责建立和完善工作程序、岗位职责等");
        humanResource.add(hr);
        humanResource.add(administration);

        Organization technology = new ParentOrganization("技术部", "负责公司技术产品研发");
        Organization frontend = new LeafOrganization("前端部", "负责前端开发");
        Organization backend = new LeafOrganization("后端部", "负责后端开发");
        Organization test = new LeafOrganization("测试部", "负责产品质量保障");
        technology.add(frontend);
        technology.add(backend);
        technology.add(test);

        // 公司下属人力资源部及技术部
        company.add(humanResource);
        company.add(technology);

        System.out.println("设计模式控股公司下部门:");
        company.getChildren();
        System.out.println("人力资源部下部门:");
        humanResource.getChildren();
        System.out.println("技术部下部门:");
        technology.getChildren();
    }
}
