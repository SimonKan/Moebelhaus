/*
 * CustomerPrintController.java
 *
 * Created on 23.02.2013, 14:53:56
 */
package controller.customer.search;

import controller.Controller;
import customer.Customer;
import main.Model;

/**
 * Controller zum Ausdrucken der Suchliste, nach einer Suche von Kunden.
 * Im Suchmenü des CustomerSeachNavigators.
 *
 * @author Simon
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class CustomerPrintSearchController extends Controller {

    public CustomerPrintSearchController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Gesuchte Kunden anzeigen";
    }

    @Override
    public String getToken() {
        return "print";
    }

    @Override
    public void showMenu() {
        println("Dies sind die gesuchten Kunden.");
        println("");
        println("");

        model.getCustomerList().sortByUniqueId(true);
        for (Customer c : model.getCustomerSearchList().toList()) {
            println(c.toString());
        }

        println("");
        println("");
    }

    @Override
    protected int read() {
        return SUCCESS;
    }
}
