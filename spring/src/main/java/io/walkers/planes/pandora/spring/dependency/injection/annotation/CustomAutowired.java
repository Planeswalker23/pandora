package io.walkers.planes.pandora.spring.dependency.injection.annotation;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.*;

/**
 * 自定义的可替换 {@link Autowired} 的注入注解
 *
 * @author planeswalker23
 * @date 2021/11/21
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Autowired
public @interface CustomAutowired {
}
