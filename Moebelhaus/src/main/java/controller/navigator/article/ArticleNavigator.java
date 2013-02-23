/*
 * CustomerNavigator.java
 *
 * Created on 21.02.2013, 13:31:36
 */
package controller.navigator.article;

import controller.navigator.Navigator;
import controller.navigator.Navigator;
import main.Model;

/**
 *
 *
 * @Simon
 *
 *
 */
public class ArticleNavigator extends Navigator {

    public ArticleNavigator(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Artikel";
    }

    @Override
    public String getToken() {
        return "article";
    }

    @Override
    public void showMenu() {
        println("Artikelmenu");
        println("");
        super.showMenu();
    }
}