/*
 * ArticleAddNavigator.java
 *
 * Created on 23.02.2013, 15:41:44
 */
package controller.article.add;

import controller.Navigator;
import main.Model;

/**
 *
 *
 * @author Simon
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class ArticleAddNavigator extends Navigator {

    public ArticleAddNavigator(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Artikel hinzufügen";
    }

    @Override
    public String getToken() {
        return "add";
    }

    @Override
    public void showMenu() {
        println("Hinzufügen eines neuen Artikels");
        println("");
        println("Wählen Sie eine der folgenden Optionen aus oder geben Sie");
        println("'abort' ein, um zurück ins Hauptmenü zu gelangen.");
        println("Geben Sie 'exit' ein, um das Programm zu beenden");
        println("");
        super.showMenu();
    }
}
