/*
 * CustomerNavigator.java
 *
 * Created on 21.02.2013, 13:31:36
 */
package controller.navigator;

import main.Model;

/**
 *
 *
 * @author Immanuel Haffner <s9imhaff@stud.uni-saarland.de>
 * @since 21.02.2013
 * @version 1.0.0
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
        println("Kundencontroller");
        println("");
        super.showMenu();
    }
}
