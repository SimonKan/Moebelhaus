/*
 * DiscountFour.java
 *
 * Created on 20.02.2013, 20:30:41
 */
package order.discount;

import order.Order;

/**
 *
 *
 * @author Simon
 *
 */
public class DiscountFour extends Discount {

    private final float offtake;

    public DiscountFour(float offtake) {
        super(1);
        this.offtake = offtake;
    }

    @Override
    public void apply(Order order) {
        order.setPrice(Math.max(0f, order.getPrice() - offtake));
    }
    
    // TODO toString
}
