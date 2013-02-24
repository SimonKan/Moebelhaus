/*
 * ArticlePrintController.java
 *
 * Created on 23.02.2013, 15:18:34
 */
package controller.article;

import article.ConcreteArticle;
import controller.Controller;
import main.Model;

/**
 * ControllerKlasse zum Anzeigen aller vorhandenen Kunden im System. 
 *
 * @author Simon
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class ArticlePrintController extends Controller {

    public ArticlePrintController(Model model) {
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
        println("Dies sind alle Artikel.");
        println("");
        println("");
        
// Sortiert die Kunden nach der UniqueId
        
        model.getArticleList().sortByUniqueId(true);
        for (ConcreteArticle a : model.getArticleList().toList()) {
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
