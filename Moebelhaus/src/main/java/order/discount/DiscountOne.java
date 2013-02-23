/*
 * DiscountOne.java
 *
 * Created on 04.02.2013, 19:21:49
 */
package order.discount;

import order.Order;

/**
 *
 *
 * @author Simon
 * @since 04.02.2013
 * @version 1.0.0
 *
 */
public class DiscountOne extends Discount {

    private final float percentage0;
    private final float percentage1;

    public DiscountOne(float percentage0, float percentage1) {
        super(1);
        this.percentage0 = percentage0;
        this.percentage1 = percentage1;
    }

    @Override
    public void apply(Order order) {
        order.setPrice(order.getPricePure() * (1 - percentage0) * (1 - percentage1));
    }
    
    @Override
    public String toString() {
        return "Wendet zerst " + percentage0 + "% Rabatt an,"
            + "danach nochmal " + percentage1 + "% Rabatt";
    }
}
