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
public class ArticleSearchByArticleIdController extends Controller {

    public ArticleSearchByArticleIdController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Id";
    }

    @Override
    public String getToken() {
        return "id";
    }

    @Override
    public void showMenu() {
    }

    @Override
    protected int read() {
        print("Bitte Artikel-Id eingeben: ");
        long id = input.nextLong();
        input.nextLine();
        model.setArticleSearchList(
            model.getArticleSearchList().getArticlesByArticleId(id));
        println("");
        println("");

        return SUCCESS;
    }
}
