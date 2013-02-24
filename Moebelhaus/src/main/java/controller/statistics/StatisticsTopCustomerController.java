/*
 * StatisticsTopCustomerController.java
 *
 * Created on 24.02.2013, 18:08:43
 */
package controller.statistics;

import controller.Controller;
import customer.Customer;
import java.util.Arrays;
import main.Model;
import order.Order;

/**
 *
 *
 * @author Simon <s9imhaff@stud.uni-saarland.de>
 * @since 24.02.2013
 * @version 1.0.0
 *
 */
public class StatisticsTopCustomerController extends Controller {

    public static final int amount = 5;

    public StatisticsTopCustomerController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Wichtigste " + amount + " Kunden";
    }

    @Override
    public String getToken() {
        return "customers";
    }

    @Override
    public void showMenu() {
        println("Hier sehen Sie die " + amount + " Kunden mit der höchsten");
        println("Kaufkraft, geordnet in absteigender Reihenfolge.");
        println("");

        float[] money = new float[model.getCustomerList().toList().size()];
        Arrays.fill(money, 0f);    // alle Werte mit 0 initialisieren

        for (Order order : model.getOrderList().toList()) {
            int index = model.getCustomerList().toList().indexOf(order.getCustomer());
            money[index] += order.getPrice();
        }

        int size = Math.min(amount, model.getCustomerList().toList().size());

        Customer[] customers = new Customer[size];  // Top 10 Kunden

        for (int i = 0; i < size; i++) {
            float max = -1f;
            int index = 0;

            // Finde Kunden mit momentan höchster Kaufkraft
            for (int j = 0; j < money.length; j++) {
                if (money[j] > max) {
                    max = money[j];
                    index = j;
                }
            }

            println("\t" + model.getCustomerList().toList().get(index)
                + "\t  [" + money[index] + "€]");
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
