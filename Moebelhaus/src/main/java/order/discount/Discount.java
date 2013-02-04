/*
 * Discount.java
 *
 * Created on 04.02.2013, 19:20:41
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
public interface Discount {
    
    void apply(Order order);

}
