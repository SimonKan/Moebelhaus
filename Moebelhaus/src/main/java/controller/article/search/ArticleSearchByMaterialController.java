/*
 * CustomerSearchByFistNameController.java
 *
 * Created on 23.02.2013, 14:18:16
 */
package controller.article.search;

import controller.Controller;
import main.Model;

/**
 * Controller zum Durchsuchen der Artikelliste anhand des Materials.
 *
 * @author Simon
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class ArticleSearchByMaterialController extends Controller {

    public ArticleSearchByMaterialController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Material";
    }

    @Override
    public String getToken() {
        return "mat";
    }

    @Override
    public void showMenu() {
    }

    @Override
    protected int read() {
        print("Bitte Material eingeben: ");
        int material = input.nextInt();
        input.nextLine();
        model.setArticleSearchList(
            model.getArticleSearchList().getArticlesByMaterial(material));
        println("");
        println("");

        return SUCCESS;
    }
}
