/*
 * Main.java
 *
 * Created on 02.02.2013, 19:10:28
 */
package main;

import controller.Controller;
import controller.CustomerController;
import controller.MainNavigator;
import controller.SearchNavigator;
import customer.AddressGermany;
import customer.Customer;

/**
 *
 *
 * @author Simon
 * @since 02.02.2013
 * @version 1.0.0
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Model model = Model.create();

        model.getCustomerList().add(Customer.create(AddressGermany.create(
            "Hans", "Lollo", "Saarbrücken", 66111, "Im Flitzepuff", "12")));

        model.getCustomerList().add(Customer.create(AddressGermany.create(
            "Max", "Mustermann", "Saarbrücken", 66111, "Im Flitzepuff", "12")));

        model.getCustomerList().add(Customer.create(AddressGermany.create(
            "Dieter", "Schmitt", "Saarbrücken", 66111, "Im Flitzepuff", "12")));


        MainNavigator main = new MainNavigator(model);
        SearchNavigator sn = new SearchNavigator(model);
        CustomerController cc = new CustomerController(model);

        sn.add(cc);
        main.add(sn);

        main.execute(0);
    }
}
