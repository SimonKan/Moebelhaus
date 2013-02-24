/*
 * CustomerSearchByFistNameController.java
 *
 * Created on 23.02.2013, 14:18:16
 */
package controller.order.search;

import controller.Controller;
import main.Model;
import order.Order;

/**
 *
 *
 * @author Simon
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class OrderSearchByCustomerIdController extends Controller {

    public OrderSearchByCustomerIdController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Kundennummer";
    }

    @Override
    public String getToken() {
        return "id";
    }

    @Override
    public void showMenu() {
    }

    @Override
    protected int read() {
        while (true) {
            print("Bitte Kundennummer eingeben: ");
            try {
                int id = Integer.parseInt(input.nextLine());

                if (model.getCustomerList().getCustomerById(id) == null) {
                    println("(!) Fehlerhafte Eingabe, Kunde existiert nicht");
                    println("");
                }

                for (Order order : model.getOrderList().toList()) {
                    if (order.getCustomer().getId() != id) {
                        model.getOrderSearchList().remove(order);
                    }
                }
                break;
            } catch (NumberFormatException ex) {
                println("(!) Fehlerhafte Eingabe, bitte geben Sie eine");
                println("\tgültige Kundennummer ein.");
                println("");
            }
        }

        println("");
        println("");

        return SUCCESS;
    }
}
