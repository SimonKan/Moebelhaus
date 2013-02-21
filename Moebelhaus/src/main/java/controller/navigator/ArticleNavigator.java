/*
 * ArticleNavigator.java
 *
 * Created on 21.02.2013, 13:38:09
 */
package controller.navigator;

import main.Model;

/**
 *
 *
 * @Simon
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
        println("Articlecontroller");
        println("");
        super.showMenu();
    }
}
