/*
 * DiscountThree.java
 *
 * Created on 20.02.2013, 20:25:26
 */
package order.discount;

import order.Order;

/**
 *
 *
 * @author Simon
 *
 */
public class DiscountThree extends Discount {

    public DiscountThree() {
        super(3);
    }

    @Override
    public void apply(Order order) {
        order.setPrice(order.getPrice() / 1.19f);
    }
    // TODO toString
}
