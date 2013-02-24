/*
 * CustomerPrintController.java
 *
 * Created on 23.02.2013, 14:53:56
 */
package controller.order;

import controller.article.*;
import article.ConcreteArticle;
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
public class OrderPrintSearchController extends Controller {

    public OrderPrintSearchController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Orders anzeigen";
    }

    @Override
    public String getToken() {
        return "print";
    }

    @Override
    public void showMenu() {
        println("Dies sind die gesuchten Orders.");
        println("");

        model.getOrderList().sortByPrice(true);
        for (Order o : model.getOrderSearchList().toList()) {
            println(o.toString());
        }
        
        println("");
        println("");
    }

    @Override
    protected int read() {
        return SUCCESS;
    }
}
// TODO RÜCKGABETYP DER ORDER KOMISCHE ANZEIGE