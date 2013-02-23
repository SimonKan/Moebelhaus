/*
 * ArticlePrintController.java
 *
 * Created on 23.02.2013, 15:18:34
 */
package controller.order;

import article.ConcreteArticle;
import controller.Controller;
import main.Model;
import order.Order;
import order.discount.Discount;

/**
 *
 *
 * @author Immanuel Haffner <s9imhaff@stud.uni-saarland.de>
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class OrderPrintController extends Controller {

    public OrderPrintController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Bestellungen anzeigen";
    }

    @Override
    public String getToken() {
        return "print";
    }

    @Override
    public void showMenu() {
        println("Dies sind alle Bestellungen");
        println("");

        model.getOrderList().sortById(true);
        for (Order o : model.getOrderList().toList()) {
            println("Bestellung #" + o.getId());
            println("\tKunde: " + o.getCustomer());
            println("");
            println("\tBestelldatum: " + o.getOrderingDate());
            if (o.isBooked()) {
                println("Buchungsdatum: " + o.getBookingDate());
            }
            if (o.isDelivered()) {
                println("Zustellungsdatum: " + o.getDeliveryDate());
            }
            println("");
            println("Artikel:");
            for (ConcreteArticle a : o.getArticles()) {
                println("\t" + a);
            }
            println("");
            println("Rabatte:");
            for (Discount d : o.getDiscounts()) {
                println("\t" + d);
            }
            println("");
            println("Preis: " + o.getPrice() + "€");
            println("");
            println("");
        }
    }

    @Override
    protected int read() {
        return SUCCESS;
    }
}
