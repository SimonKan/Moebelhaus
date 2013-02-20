/*
 * SearchNavigator.java
 *
 * Created on 20.02.2013, 22:23:37
 */
package controller;

import main.Model;
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
    public String getToken() {
        return "search";
    }

    @Override
    protected void introduce() {
        println("Was möchten Sie durchsuchen?");
        println("Customer | Article | Order");
    }
}
