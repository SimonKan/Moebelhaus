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
 *
 *
 * @author Immanuel Haffner <s9imhaff@stud.uni-saarland.de>
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class OrderRemoveController extends Controller {

    public OrderRemoveController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Bestellung löschen";
    }

    @Override
    public String getToken() {
        return "del";
    }

    @Override
    public void showMenu() {
    }

    @Override
    protected int read() {
        long id = 0;

        while (true) {
            print("ID der zu löschenden Bestellung: ");
            id = input.nextLong();
            input.nextLine();
            Order order = model.getOrderList().getOrderByUniqueId(id);
            if (order != null) {
                model.getOrderList().remove(order);
                break;
            }
            println("(!) Fehlerhafte Eingabe, Order mit ID " + id
                + "existiert nicht");
            println("");
        }

        model.setOrderSearchList(model.getOrderList());

        return SUCCESS;
    }
}
