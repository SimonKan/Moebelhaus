/*
 * OrderSearchNavigator.java
 *
 * Created on 23.02.2013, 16:37:07
 */
package controller.navigator;

import main.Model;

/**
 *
 *
 * @author Immanuel Haffner <s9imhaff@stud.uni-saarland.de>
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class OrderSearchNavigator extends Navigator {

    public OrderSearchNavigator(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Bestellungen durchsuchen";
    }

    @Override
    public String getToken() {
        return "search";
    }
}
