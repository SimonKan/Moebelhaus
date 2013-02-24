/*
 * CustomerSearchByFistNameController.java
 *
 * Created on 23.02.2013, 14:18:16
 */
package controller.article.search;

import controller.Controller;
import main.Model;

/**
 *
 *
 * @author Simon
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class ArticleSearchByNameController extends Controller {

    public ArticleSearchByNameController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Name";
    }

    @Override
    public String getToken() {
        return "name";
    }

    @Override
    public void showMenu() {
    }

    @Override
    protected int read() {
        print("Bitte Name eingeben: ");
        String name = input.nextLine().trim();
        model.setArticleSearchList(
            model.getArticleSearchList().getArticlesByName(name));
        println("");
        println("");

        return SUCCESS;
    }
}
