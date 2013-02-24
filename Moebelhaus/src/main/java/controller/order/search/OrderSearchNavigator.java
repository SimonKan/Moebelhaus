/*
 * OrderSearchNavigator.java
 *
 * Created on 23.02.2013, 16:37:07
 */
package controller.order.search;

import controller.Navigator;
import controller.Navigator;
import main.Model;

/**
 *
 *
 * @author Simon
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class OrderSearchNavigator extends Navigator {

    public OrderSearchNavigator(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Bestellungen durchsuchen";
    }

    @Override
    public String getToken() {
        return "search";
    }

    @Override
    public int read() {
        int res;
        do {
            res = super.read();
            showMenu();
        } while (res == SUCCESS);

        model.setOrderSearchList(model.getOrderList());
        return res;
    }

    @Override
    public void showMenu() {
        println("Durchsuchen der Bestellungen");
        println("");
        println("Wählen Sie eine der folgenden Optionen aus oder geben Sie");
        println("'abort' ein, um zurück ins Hauptmenü zu gelangen.");
        println("Geben Sie 'exit' ein, um das Programm zu beenden");
        println("");
        super.showMenu();
    }
}
