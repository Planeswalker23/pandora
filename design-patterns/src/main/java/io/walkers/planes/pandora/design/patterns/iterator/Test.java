package io.walkers.planes.pandora.design.patterns.iterator;

import java.util.Iterator;

/**
 * @author Planeswalker23
 */
public class Test {

    public static void main(String[] args) {
        UserCoupon userCoupon = new UserCoupon();
        userCoupon.add(new Coupon("满100-10券"));
        userCoupon.add(new Coupon("满200-20券"));
        userCoupon.add(new Coupon("满300-30券"));

        Iterator<Coupon> iterator = userCoupon.getIterator();
        while (iterator.hasNext()) {
            Coupon next = iterator.next();
            System.out.println(next.getName());
        }
    }
}
