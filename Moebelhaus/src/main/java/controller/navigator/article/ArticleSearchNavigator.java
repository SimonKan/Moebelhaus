/*
 * CustomerSearchNavigator.java
 *
 * Created on 23.02.2013, 14:17:21
 */
package controller.navigator.article;

import controller.navigator.Navigator;
import controller.navigator.Navigator;
import main.Model;

/**
 *
 *
 * @author Simon
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class ArticleSearchNavigator extends Navigator {

    public ArticleSearchNavigator(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Artikel durchsuchen";
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

        model.setArticleSearchList(model.getArticleList());
        return res;
    }
}
