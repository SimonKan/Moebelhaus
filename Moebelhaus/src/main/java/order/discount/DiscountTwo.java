/*
 * DiscountTwo.java
 *
 * Created on 20.02.2013, 20:15:55
 */
package order.discount;

import order.Order;

/**
 *
 *
 * @author Simon
 */
public class DiscountTwo extends Discount {

    private final float threshold;
    private final float offtake;

    public DiscountTwo(float threshold, float offtake) {
        super(2);
        if (offtake >= threshold) {
            throw new IllegalArgumentException("offtake must be smaller than "
                + "threshold");
        }
        this.threshold = threshold;
        this.offtake = offtake;
    }

    @Override
    public void apply(Order order) {
        float price = order.getPricePure();
        if (price >= threshold) {
            order.setPrice(price - offtake);
        }
    }

    @Override
    public String toString() {
        return "Wendet bei einem Mindestkaufpreis" + threshold + "einen Abzug von"
            + offtake + "an ";
    }
}
