package io.walkers.planes.pandora.spring.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * UserService 增强类
 *
 * 一般顺序：
 *  环绕之前 @Around
 *  前置通知 @Before
 *  登录服务执行方法
 *  后置通知 @AfterReturning
 *  最终通知 @After
 *  环绕之后 @Around
 *
 * 存在异常顺序：
 *  环绕之前 @Around
 *  登录服务执行方法，抛出异常
 *  异常通知 @AfterThrowing
 *  最终通知 @After
 *
 * @author planeswalker23
 * @date 2021/11/7
 */
@Aspect
@Component
// 在增强类上面添加注解 @Order(数字类型值)，数字类型值越小优先级越高
@Order(1)
public class UserServiceProxy {

    // 相同切入点抽取，复用切入点
    @Pointcut(value = "execution(* io.walkers.planes.pandora.spring.aop.aspectj.LoginService.doSomething(..))")
    public void pointCut() {

    }

    // 切入点表达式语法结构
    // execution([权限修饰符] [返回类型] [类全路径] [方法名称]([参数列表]) )
    //            * 表示所有访问类型
    //            返回类型为 void
    //            .. 表示不指定参数列表

    // @Before 前置通知
    @Before(value = "pointCut()")
    public void before() {
        System.out.println("前置通知 @Before");
    }

    //后置通知(返回通知)
    @AfterReturning(value = "pointCut()")
    public void afterReturning() {
        System.out.println("后置通知(返回通知) @AfterReturning");
    }

    // 最终通知
    @After(value = "pointCut()")
    public void after() {
        System.out.println("最终通知 @After");
    }

    // 异常通知
    @AfterThrowing(value = "pointCut()")
    public void afterThrowing() {
        System.out.println("异常通知 @AfterThrowing");
    }

    // 环绕通知
    @Around(value = "pointCut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前 @Around");

        // 被增强的方法执行
        proceedingJoinPoint.proceed();

        System.out.println("环绕之后 @Around");
    }
}
