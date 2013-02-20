/*
 * CustomerController.java
 *
 * Created on 20.02.2013, 22:40:10
 */
package controller;

import customer.Customer;
import java.util.List;
import main.Model;

/**
 *
 *
 * @author Immanuel Haffner <s9imhaff@stud.uni-saarland.de>
 * @since 20.02.2013
 * @version 1.0.0
 *
 */
public class CustomerController extends Controller {

    public CustomerController(Model model) {
        super(model);
    }

    @Override
    public String getToken() {
        return "customer";
    }

    @Override
    protected void introduce() {
        println("Customer durchsuchen");
        println("name | age");
    }

    @Override
    protected int read() {
        String in = input.next();
        switch (in) {
            case "name":
                print("Enter name: ");
                String name = input.next();

                for (Customer c : getModel().getCustomerList().getCustomerByFirstName(name).toList()) {
                    println(c.toString());
                }

                return SUCCESS;
            default:
                return ABORT;
        }
    }
}
