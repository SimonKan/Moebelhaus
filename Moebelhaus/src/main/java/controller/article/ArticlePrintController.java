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
 *
 *
 * @author Immanuel Haffner <s9imhaff@stud.uni-saarland.de>
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
        return "Zeigt alle Artikel an";
    }

    @Override
    public String getToken() {
        return "print";
    }

    @Override
    public void showMenu() {
        println("Dies sind alle Artikel");
        println("");

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
