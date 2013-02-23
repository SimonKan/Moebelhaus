/*
 * CustomerPrintController.java
 *
 * Created on 23.02.2013, 14:53:56
 */
package controller.customer;

import controller.Controller;
import customer.Customer;
import main.Model;

/**
 *
 *
 * @author Immanuel Haffner <s9imhaff@stud.uni-saarland.de>
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class CustomerPrintController extends Controller {

    public CustomerPrintController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Kunden anzeigen";
    }

    @Override
    public String getToken() {
        return "print";
    }

    @Override
    public void showMenu() {
        println("Dies sind alle Kunden.");
        println("");

        model.getCustomerList().sortByUniqueId(true);
        for (Customer c : model.getCustomerList().toList()) {
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
