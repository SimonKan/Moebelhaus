/*
 * OrderNavigator.java
 *
 * Created on 21.02.2013, 13:39:01
 */
package controller.order;

import controller.Navigator;
import controller.Navigator;
import main.Model;

/**
 *
 *
 * @@author Simon
 *
 */
public class OrderNavigator extends Navigator {

    public OrderNavigator(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Bestellungen";
    }

    @Override
    public String getToken() {
        return "order";
    }

    @Override
    public void showMenu() {
        println("Ordercontroller");
        println("");
        super.showMenu();
    }
}
