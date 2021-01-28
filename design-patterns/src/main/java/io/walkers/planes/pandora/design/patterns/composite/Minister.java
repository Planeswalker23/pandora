package io.walkers.planes.pandora.design.patterns.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 部长身份拥有下级干事，或下级是部长的主席
 * @author Planeswalker23
 * @date Created in 2019-09-16
 */
public class Minister extends Student {

    /**
     * 部长级干部拥有自己的干事，负责某一部门的运作
     * 主席的下级是部长，负责整个协会的运作
     */
    private List<Student> followers = new ArrayList<>();
    /**
     * 构造方法
     * @param name
     * @param identity
     */
    public Minister(String name, String identity) {
        super(name, identity);
    }

    /**
     * 给部长增加干事
     * @param student
     */
    public void add(Student student) {
        this.followers.add(student);
    }

    /**
     * 给部长减少干事
     * @param student
     */
    public void del(Student student) {
        this.followers.add(student);
    }

    public void getChildren() {
        Iterator<Student> iterator = this.followers.iterator();
        while (iterator.hasNext()) {
            iterator.next().job();
        }
    }
}
