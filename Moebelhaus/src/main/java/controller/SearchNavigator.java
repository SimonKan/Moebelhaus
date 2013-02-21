/*
 * SearchNavigator.java
 *
 * Created on 20.02.2013, 22:23:37
 */
package controller;

import main.Model;

/**
 *
 *
 * @author Immanuel Haffner <s9imhaff@stud.uni-saarland.de>
 * @since 20.02.2013
 * @version 1.0.0
 *
 */
public class SearchNavigator extends Navigator {

    public SearchNavigator(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Suchen";
    }

    @Override
    public String getToken() {
        return "search";
    }
    
    @Override
    public void showMenu() {
        println("Wählen Sie einen Bereich aus, den Sie durchsuchen möchten.");
        println("");
        super.showMenu();
    }
}
