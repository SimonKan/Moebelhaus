/*
 * CustomerSearchByFistNameController.java
 *
 * Created on 23.02.2013, 14:18:16
 */
package controller.article;

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
        Integer material = input.nextInt();
        model.setArticleSearchList(
            model.getArticleSearchList().getArticlesByMaterial(material));
        println("");
        println("");

        return SUCCESS;
    }
}
