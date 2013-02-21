/*
 * Main.java
 *
 * Created on 02.02.2013, 19:10:28
 */
package main;

import controller.CustomerManagementController;
import controller.CustomerSearchController;
import controller.StatisticsController;
import controller.navigator.ArticleNavigator;
import controller.navigator.CustomerNavigator;
import controller.navigator.MainNavigator;
import controller.navigator.OrderNavigator;
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
            "Hans", "Lollo", 66111, "Saarbrücken", "Im Flitzepuff", "12")));

        model.getCustomerList().add(Customer.create(AddressGermany.create(
            "Max", "Mustermann", 66111, "Saarbrücken", "Im Flitzepuff", "12")));

        model.getCustomerList().add(Customer.create(AddressGermany.create(
            "Dieter", "Schmitt", 66111, "Saarbrücken", "Im Flitzepuff", "12")));

        CustomerNavigator cn = new CustomerNavigator(model);
        cn.add(new CustomerManagementController(model));
        cn.add(new CustomerSearchController(model));

        OrderNavigator on = new OrderNavigator(model);

        ArticleNavigator an = new ArticleNavigator(model);


        MainNavigator main = new MainNavigator(model);
        main.add(an);
        main.add(cn);
        main.add(on);
        main.add(new StatisticsController(model));

        main.execute(0);
    }
}
