package io.walkers.planes.pandora.design.patterns.template.v2;

/**
 * @author Planeswalker23
 */
public interface BaseCreateService<Model> {

    // 校验方法
    void validate(Model model);

    // 填充方法
    void fill(Model model);

    // 持久化方法
    int create(Model model);

    // 后置业务（钩子函数）
    default void postHandler(Model model) {

    }

    // 控制钩子函数是否执行
    default boolean hook() {
        return false;
    }

    // 模板方法
    default int doCreate(Model model) {
        this.validate(model);
        this.fill(model);
        int id = this.create(model);
        if (this.hook()) {
            this.postHandler(model);
        }
        return id;
    }
}
