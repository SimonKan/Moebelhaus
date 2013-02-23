/*
 * CustomerSearchNavigator.java
 *
 * Created on 23.02.2013, 14:17:21
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
public class CustomerSearchNavigator extends Navigator {

    public CustomerSearchNavigator(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Kunden durchsuchen";
    }

    @Override
    public String getToken() {
        return "search";
    }

    @Override
    public int read() {
        int res;
        do {
            res = super.read();
            showMenu();
        } while (res == SUCCESS);

        model.setCustomerSearchList(model.getCustomerList());
        return res;
    }
}
