package ioc.bean.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author planeswalker23
 * @date 2021/11/4
 */
@Component
public class UserService {

    public void method() {
        System.out.println("UserService#method");
    }

    // @Autowired: 根据类型注入
    @Autowired
    private UserDao injectByType;

    public void injectByType() {
        injectByType.daoMethod();
        System.out.println("UserService#injectByType");
    }

    // @Qualifier: 根据名称注入，需要与 @Autowired 配合一起使用
    @Autowired
    @Qualifier(value = "userDaoImpl1")
    private UserDao injectByQualifier;

    public void injectByQualifier() {
        injectByQualifier.daoMethod();
        System.out.println("UserService#injectByQualifier");
    }

    // @Resource: 可以根据名称注入，也可以根据类型注入，默认根据类型注入
    @Resource
//    @Resource(name = "userDaoImpl2")
//    @Resource(type = UserDao.class)
    private UserDao userDaoImpl2;

    public void injectByResource() {
        userDaoImpl2.daoMethod();
        System.out.println("UserService#userDaoImpl2");
    }


}
