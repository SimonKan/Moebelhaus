/*
 * CustomerNavigator.java
 *
 * Created on 21.02.2013, 13:31:36
 */
package controller.customer;

import controller.Navigator;
import main.Model;

/**
 * Navigator zum Erzeugen des KundenMenüs.
 *
 * @Simon
 *
 *
 */
public class CustomerNavigator extends Navigator {

    public CustomerNavigator(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Kunden";
    }

    @Override
    public String getToken() {
        return "customer";
    }

    @Override
    public void showMenu() {
        println("Kundenverwaltung");
        println("");
        println("Wählen Sie eine der folgenden Optionen aus oder geben Sie");
        println("'abort' ein, um zurück ins Hauptmenü zu gelangen.");
        println("Geben Sie 'exit' ein, um das Programm zu beenden");
        println("");
        super.showMenu();
    }
}
