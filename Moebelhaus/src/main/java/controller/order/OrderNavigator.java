/*
 * OrderNavigator.java
 *
 * Created on 21.02.2013, 13:39:01
 */
package controller.order;

import controller.Navigator;
import controller.Navigator;
import main.Model;

/**
 * HauptNavigator der Klasse Order.
 *
 * @author Simon
 *
 */
public class OrderNavigator extends Navigator {

    public OrderNavigator(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Bestellungen";
    }

    @Override
    public String getToken() {
        return "order";
    }

    @Override
    public void showMenu() {
        println("Verwaltung der Bestellungen");
        println("");
        println("Wählen Sie eine der folgenden Optionen aus oder geben Sie");
        println("'abort' ein, um zurück ins Hauptmenü zu gelangen.");
        println("Geben Sie 'exit' ein, um das Programm zu beenden");
        println("");
        super.showMenu();
    }
}
