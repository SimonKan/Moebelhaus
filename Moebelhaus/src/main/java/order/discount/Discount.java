/*
 * Discount.java
 *
 * Created on 04.02.2013, 19:20:41
 */
package order.discount;

import order.Order;

/**
 * Discount realisiert ein KommandPattern Die Order ruft die Methode apply des
 * Discounts auf, sodass Discount auf die Summe der Order angewand wird
 *
 * @author Simon
 * @since 04.02.2013
 * @version 1.0.0
 *
 */
public abstract class Discount implements Comparable<Discount> {

    private final int id;

    public Discount(int id) {
        this.id = id;
    }

    /**
     * TODO Implementiern
     *
     * @param order
     */
    public abstract void apply(Order order);

    @Override
    public int compareTo(Discount other) {
        return this.id - other.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Discount other = (Discount) obj;
        return this.id == other.id;
    }
}
