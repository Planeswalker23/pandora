package io.walkers.planes.pandora.design.patterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Planeswalker23
 */
public class UserCoupon {

    private List<Coupon> list = new ArrayList<>();

    public void add(Coupon coupon) {
        list.add(coupon);
    }

    public void remove(Coupon coupon) {
        list.remove(coupon);
    }

    public Iterator<Coupon> getIterator() {
        return list.iterator();
    }
}
