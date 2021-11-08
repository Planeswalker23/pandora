package io.walkers.planes.pandora.spring.custom.bean;

import io.walkers.planes.pandora.spring.custom.core.BeanScope;
import io.walkers.planes.pandora.spring.custom.core.annotation.CustomComponent;
import io.walkers.planes.pandora.spring.custom.core.annotation.CustomScope;

/**
 * 自定义的 Bean
 *
 * @author planeswalker23
 */
@CustomScope(BeanScope.PROTOTYPE)
@CustomComponent("userService")
public class UserService {
}
