package io.walkers.planes.pandora.spring.aop.jdk;

/**
 * 登录接口实现类
 *
 * @author planeswalker23
 * @date 2021/11/6
 */
public class LoginServiceImpl implements LoginService {

    @Override
    public void login(String id) {
        System.out.println("id = " + id + " login successfully.");
    }
}
