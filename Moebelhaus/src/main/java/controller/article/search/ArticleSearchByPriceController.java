/*
 * CustomerSearchByFistNameController.java
 *
 * Created on 23.02.2013, 14:18:16
 */
package controller.article.search;

import controller.Controller;
import main.Model;

/**
 * ControllerKlasse zum Durchsuchen der Artikelliste anhand des Preises
 * Mit oberer und unterer Grenze.
 *
 * @author Simon
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class ArticleSearchByPriceController extends Controller {

    public ArticleSearchByPriceController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Preis";
    }

    @Override
    public String getToken() {
        return "price";
    }

    @Override
    public void showMenu() {
    }

    @Override
    protected int read() {
        print("Bitte Preisuntergrenze eingeben: ");
        float lowerBound = input.nextFloat();
        input.nextLine();
        print("Bitte Preisobergrenze eingeben: ");
        float upperBound = input.nextLong();
        input.nextLine();
        model.setArticleSearchList(
            model.getArticleSearchList().getArticlesByPrice(lowerBound,
                                                            upperBound));
        println("");
        println("");

        return SUCCESS;
    }
}
