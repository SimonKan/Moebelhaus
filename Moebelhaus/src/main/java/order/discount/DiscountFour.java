/*
 * DiscountFour.java
 *
 * Created on 20.02.2013, 20:30:41
 */
package order.discount;

import order.Order;

/**
 * Discount der einen festlegbaren Rabatt auf die Rechnung gibt.
 * Dieser wird von der RechnungsSumme abgezogen.
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
        order.setPrice(Math.max(0f, order.getPricePure() - offtake));
    }

    @Override
    public String toString() {
        return "Wendet einen Abzug von " + offtake + " an";
    }
}
