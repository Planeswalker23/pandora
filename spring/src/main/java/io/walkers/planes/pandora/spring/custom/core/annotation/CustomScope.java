package io.walkers.planes.pandora.spring.custom.core.annotation;

import io.walkers.planes.pandora.spring.custom.core.BeanScope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义的 Bean 作用域注解
 *
 * @author planeswalker23
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CustomScope {

    BeanScope value();
}
