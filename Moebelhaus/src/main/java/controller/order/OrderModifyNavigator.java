/*
 * OrderModifyNavigator.java
 *
 * Created on 23.02.2013, 18:43:30
 */
package controller.order;

import controller.Navigator;
import main.Model;

/**
 * Navigator der das ModifyMenü aufbaut.
 *
 * @author Simon
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class OrderModifyNavigator extends Navigator {

    public OrderModifyNavigator(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Bestellungen bearbeiten";
    }

    @Override
    public String getToken() {
        return "mod";
    }

    @Override
    public void showMenu() {
        println("Bearbeiten einer Bestellung");
        println("");
        println("Wählen Sie eine der folgenden Optionen aus oder geben Sie");
        println("'abort' ein, um zurück ins Hauptmenü zu gelangen.");
        println("Geben Sie 'exit' ein, um das Programm zu beenden");
        println("");
        super.showMenu();
    }
}
