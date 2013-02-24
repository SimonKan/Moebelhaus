/*
 * CustomerSearchByFistNameController.java
 *
 * Created on 23.02.2013, 14:18:16
 */
package controller.article.search;

import controller.Controller;
import main.Model;

/**
 * Controller zum Durchsuchen der ArticleList anhand der Id des Artikels.
 *
 * @author Simon
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class ArticleSearchByArticleIdController extends Controller {

    public ArticleSearchByArticleIdController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Artikel ID";
    }

    @Override
    public String getToken() {
        return "aid";
    }

    @Override
    public void showMenu() {
    }

    @Override
    protected int read() {
        print("Bitte Artikel-ID eingeben: ");
        long id = input.nextLong();
        input.nextLine();
        model.setArticleSearchList(
            model.getArticleSearchList().getArticlesByArticleId(id));
        println("");
        println("");

        return SUCCESS;
    }
}
