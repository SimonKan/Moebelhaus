/*
 * StatisticsTopCustomerController.java
 *
 * Created on 24.02.2013, 18:08:43
 */
package controller.statistics;

import controller.Controller;
import java.util.Arrays;
import main.Model;
import order.Order;

/**
 *
 *
 * @author Simon
 * @since 24.02.2013
 * @version 1.0.0
 *
 */
public class StatisticsTopCityController extends Controller {

    private final int amount;

    public StatisticsTopCityController(Model model, int amount) {
        super(model);
        this.amount = amount;
    }

    @Override
    public String getName() {
        return "Wichtigste " + amount + " Städte";
    }

    @Override
    public String getToken() {
        return "customers";
    }

    @Override
    public void showMenu() {
        println("Hier sehen Sie die " + amount + " Städte mit der höchsten");
        println("Kaufkraft, geordnet in absteigender Reihenfolge.");
        println("");

        float[] money = new float[100000];  // 90.000 mögliche Plz (10.000 - 100.000)
        // der Einfachheit wegen nehmen wir 100.000

        Arrays.fill(money, 0f);    // alle Werte mit 0 initialisieren

        for (Order order : model.getOrderList().toList()) {
            money[order.getCustomer().getAddressGermany().getPlz()] += order.getPrice();
        }

        int size = Math.min(amount, model.getCustomerList().toList().size());

        int[] plzs = new int[size];  // Top 10 Plz's

        for (int i = 0; i < size; i++) {
            float max = -1f;
            int index = 0;

            // Finde Plz mit momentan höchster Kaufkraft
            for (int j = 0; j < money.length; j++) {
                if (money[j] > max) {
                    max = money[j];
                    index = j;
                }
            }

            // wenn Plz gültig
            if (index >= 10000) {
                println("\t" + index);
            }
            money[index] = -1f;
        }

        println("");
        println("");
    }

    @Override
    protected int read() {
        return SUCCESS;
    }
}
