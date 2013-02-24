/*
 * CustomerPrintController.java
 *
 * Created on 23.02.2013, 14:53:56
 */
package controller.article;

import article.ConcreteArticle;
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
public class ArticlePrintSearchController extends Controller {

    public ArticlePrintSearchController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Artikel anzeigen";
    }

    @Override
    public String getToken() {
        return "print";
    }

    @Override
    public void showMenu() {
        println("Dies sind die gesuchten Artikel.");
        println("");

        model.getArticleList().sortByUniqueId(true);
        for (ConcreteArticle a : model.getArticleSearchList().toList()) {
            println(a.toString());
        }
        
        println("");
        println("");
    }

    @Override
    protected int read() {
        return SUCCESS;
    }
}
