/*
 * StatisticsPerformanceController.java
 *
 * Created on 24.02.2013, 18:48:05
 */
package controller.statistics;

import controller.Controller;
import main.Model;
import order.Order;

/**
 * TODO
 *
 * @author Simon
 * @since 24.02.2013
 * @version 1.0.0
 *
 */
public class StatisticsPerformanceController extends Controller {

    public StatisticsPerformanceController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Performance";
    }

    @Override
    public String getToken() {
        return "perf";
    }

    @Override
    public void showMenu() {
        println("Hier sehen Sie einige Statistiken zur Effizienz ihres "
            + "Unternehmens.");
        println("");

        int bookedOrders = 0;
        float price = 0;

        int deliveredOrders = 0;
        long time = 0;

        for (Order order : model.getOrderList().toList()) {
            if (order.isBooked()) {
                bookedOrders++;
                price += order.getPrice();
            }
            if (order.isDelivered()) {
                deliveredOrders++;
                time += order.getDeliveryDate().getTime()
                    - order.getBookingDate().getTime();
            }
        }

        // Durchschnitt berechnen
        price /= bookedOrders;

        // Durchschnitt berechnen
        time /= deliveredOrders;

        // In Sekunden umrechnen
        time /= 1000;
        // In Stunden umrechnen
        time /= 60 * 60;

        // Tage berechnen
        float days = time / 24f;


        println("Durchschnittlicher Wert einer Bestellung: " + price + "€");
        println("Durchschnittliche Lieferzeit: " + days + " Tage");
    }

    @Override
    protected int read() {
        return SUCCESS;
    }
}
