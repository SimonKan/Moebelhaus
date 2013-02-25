/*
 * OrderAddController.java
 *
 * Created on 23.02.2013, 16:41:02
 */
package controller.order;

import controller.Controller;
import customer.Customer;
import main.Model;
import order.Order;

/**
 * Controller zum Hinzufügen einer neuen Order eines Kunden.
 * Die Order bekommt eine automatische Id. Der Kunde wird über seine UniqueId
 * angegeben.
 *
 * @author Simon
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class OrderAddController extends Controller {

    public OrderAddController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Bestellung hinzufügen";
    }

    @Override
    public String getToken() {
        return "add";
    }

    @Override
    public void showMenu() {
        println("Füllen Sie die folgenden Felder aus.");
    }

    @Override
    protected int read() {
        Customer customer = null;

        while (true) {
            print("ID des Käufers: ");
            long id = input.nextLong();
            input.nextLine();
            customer = model.getCustomerList().getCustomerById(id);
            if (customer != null) {
                break;
            }
            println("(!) Fehlerhafte Eingabe, Kunde mit ID " + id
                + "existiert nicht");
            println("");
        }

        model.getOrderList().add(Order.create(customer));
        model.setOrderSearchList(model.getOrderList());

        return SUCCESS;
    }
}
