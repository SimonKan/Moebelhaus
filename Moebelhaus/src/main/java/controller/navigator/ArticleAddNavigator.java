/*
 * ArticleAddNavigator.java
 *
 * Created on 23.02.2013, 15:41:44
 */
package controller.navigator;

import main.Model;

/**
 *
 *
 * @author Immanuel Haffner <s9imhaff@stud.uni-saarland.de>
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class ArticleAddNavigator extends Navigator {

    public ArticleAddNavigator(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Artikel hinzufügen";
    }

    @Override
    public String getToken() {
        return "add";
    }
}
