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
 * @author Immanuel Haffner <s9imhaff@stud.uni-saarland.de>
 * @since 20.02.2013
 * @version 1.0.0
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
}
