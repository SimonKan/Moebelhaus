/*
 * OrderModifyNavigator.java
 *
 * Created on 23.02.2013, 18:43:30
 */
package controller.order;

import controller.navigator.Navigator;
import main.Model;

/**
 *
 *
 * @author Simon
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class OrderModifyNavigator extends Navigator {

    public OrderModifyNavigator(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Bestellungen bearbeiten";
    }

    @Override
    public String getToken() {
        return "mod";
    }
}
