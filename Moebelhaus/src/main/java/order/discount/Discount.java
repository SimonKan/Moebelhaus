/*
 * Discount.java
 *
 * Created on 04.02.2013, 19:20:41
 */
package order.discount;

import order.Order;

/**
 * Discount realisiert ein KommandPattern
 * Die Order ruft die Methode apply des Discounts auf, sodass Discount auf die
 * Summe der Order angewand wird
 *
 * @author Simon
 * @since 04.02.2013
 * @version 1.0.0
 *
 */
public interface Discount {

    /**
     * TODO Implementiern
     * @param order
     */
    void apply(Order order);
}
