package io.walkers.planes.pandora.spring.ioc.inject;

/**
 * 会员，包含 User 对象的属性
 *
 * @author planeswalker23
 */
public class Customer {

    private User user;
    private Integer customerNo;

    // 级联赋值必须要有 get 方法
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCustomerNo(Integer customerNo) {
        this.customerNo = customerNo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "user=" + user +
                ", customerNo=" + customerNo +
                '}';
    }
}
