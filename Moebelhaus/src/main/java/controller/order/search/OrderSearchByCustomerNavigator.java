/*
 * OrderSearchByCustomerNavigator.java
 *
 * Created on 24.02.2013, 17:51:02
 */
package controller.order.search;

import controller.Navigator;
import main.Model;

/**
 *
 *
 * @author Simon <s9imhaff@stud.uni-saarland.de>
 * @since 24.02.2013
 * @version 1.0.0
 *
 */
public class OrderSearchByCustomerNavigator extends Navigator {

    public OrderSearchByCustomerNavigator(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Kunde";
    }

    @Override
    public String getToken() {
        return "customer";
    }
}
