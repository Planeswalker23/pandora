package io.walkers.planes.pandora.spring.dependency.injection.annotation;

import java.lang.annotation.*;

/**
 * 自定义的可实现注入功能的注解
 *
 * @author planeswalker23
 * @date 2021/11/21
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NewAutowired {
}
