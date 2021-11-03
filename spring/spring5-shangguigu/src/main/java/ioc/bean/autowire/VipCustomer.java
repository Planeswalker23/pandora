package ioc.bean.autowire;

import ioc.bean.User;

/**
 * VIP 会员
 *
 * @author planeswalker23
 */
public class VipCustomer {

    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "VipCustomer{" +
                "user=" + user +
                '}';
    }
}
