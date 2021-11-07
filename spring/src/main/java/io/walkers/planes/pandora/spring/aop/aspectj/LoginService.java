package io.walkers.planes.pandora.spring.aop.aspectj;

import org.springframework.stereotype.Component;

/**
 * 登录接口实现类
 *
 * @author planeswalker23
 * @date 2021/11/6
 */
@Component
public class LoginService {

    public void doSomething() {
        System.out.println("登录服务执行方法");
    }

    public void doSomethingThrowException() {
        System.out.println("登录服务执行方法，抛出异常");
        throw new RuntimeException("测试异常");
    }
}
