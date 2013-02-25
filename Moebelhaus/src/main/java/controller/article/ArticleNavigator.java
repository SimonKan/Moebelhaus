/*
 * CustomerNavigator.java
 *
 * Created on 21.02.2013, 13:31:36
 */
package controller.article;

import controller.Navigator;
import main.Model;

/**
 *
 * Navigator der Klasse Artikel
 * Erbt von der NavigatorOberklasse
 * Und erzeugt das Menü in der Artikelverwaltung
 *
 * @Simon
 *
 *
 */
public class ArticleNavigator extends Navigator {

    public ArticleNavigator(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Artikel";
    }

    @Override
    public String getToken() {
        return "article";
    }

    @Override
    public void showMenu() {
        println("Artikelverwaltung");
        println("");
        println("Wählen Sie eine der folgenden Optionen aus oder geben Sie");
        println("'abort' ein, um zurück ins Hauptmenü zu gelangen.");
        println("Geben Sie 'exit' ein, um das Programm zu beenden");
        println("");
        super.showMenu();
    }
}
