package ioc.bean.annotation;

/**
 * @author planeswalker23
 * @date 2021/11/4
 */
//@Repository(value = "userDaoImpl2")
public class UserDaoImpl2 implements UserDao {

    @Override
    public void daoMethod() {
        System.out.println("UserDaoImpl2#daoMethod");
    }
}
