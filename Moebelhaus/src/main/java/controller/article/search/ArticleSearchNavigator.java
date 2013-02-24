/*
 * CustomerSearchNavigator.java
 *
 * Created on 23.02.2013, 14:17:21
 */
package controller.article.search;

import controller.Navigator;
import main.Model;

/**
 * NavigatorKlasse ( Unterklasse von Navigator), die das Menü für das Durchsuchen
 * der Listen aufbaut. 
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
    public void showMenu() {
        println("Durchsuchen der Artikel");
        println("");
        println("Wählen Sie eine der folgenden Optionen aus oder geben Sie");
        println("'abort' ein, um zurück ins Hauptmenü zu gelangen.");
        println("Geben Sie 'exit' ein, um das Programm zu beenden");
        println("");
        super.showMenu();
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
