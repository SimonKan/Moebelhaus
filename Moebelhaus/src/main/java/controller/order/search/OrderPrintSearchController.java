/*
 * CustomerPrintController.java
 *
 * Created on 23.02.2013, 14:53:56
 */
package controller.order.search;

import controller.article.*;
import article.ConcreteArticle;
import controller.Controller;
import main.Model;
import order.Order;
import order.discount.Discount;

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
        return "Gesuchte Bestellungen anzeigen";
    }

    @Override
    public String getToken() {
        return "print";
    }

    @Override
    public void showMenu() {
        println("Dies sind die gesuchten Orders.");
        println("");
        println("");

        model.getOrderSearchList().sortById(true);
        for (Order o : model.getOrderSearchList().toList()) {
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
// TODO (DONE) RÜCKGABETYP DER ORDER KOMISCHE ANZEIGE
// Statt toString (native toString) Text erzeugen wie in OrderPrintController
// siehe Zeile 43 - 69