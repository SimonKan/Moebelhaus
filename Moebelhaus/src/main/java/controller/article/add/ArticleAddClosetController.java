/*
 * CustomerAddController.java
 *
 * Created on 23.02.2013, 14:04:00
 */
package controller.article.add;

import article.ArticleFactory;
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
public class ArticleAddClosetController extends Controller {

    private ArticleFactory articleFactory;

    public ArticleAddClosetController(Model model, ArticleFactory articleFactory) {
        super(model);
        if (articleFactory == null) {
            throw new IllegalArgumentException("articleFactory was null");
        }
        this.articleFactory = articleFactory;
    }

    @Override
    public String getName() {
        return "Schrank hinzufügen";
    }

    @Override
    public String getToken() {
        return "closet";
    }

    @Override
    public void showMenu() {
        println("Bitte füllen Sie die folgenden Felder aus.");
        println("");
    }

    @Override
    protected int read() {
        long articleId = 0;
        String name = "";
        float price = 0f;
        int material = 0;
        int doors = 0;
        boolean slope = false;

        while (true) {
            print("Artikelnummer: ");
            articleId = input.nextLong();
            input.nextLine();
            if (articleId >= 0) {
                break;
            }
            println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut");
            println("");
        }

        while (true) {
            print("Name:          ");
            name = input.nextLine().trim();
            if (name.matches("[a-zA-Z][a-zA-Z ]*")) {
                break;
            }
            println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut");
            println("");
        }
        
        while (true) {
            print("Preis:         ");
            price = input.nextFloat();
            input.nextLine();
            if (price > 0) {
                break;
            }
            println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut");
            println("");
        }

        while (true) {
            println("Wählen Sie aus folgenden Materialien:");
            println("");
            println("\t1. Holz");
            println("\t2. Metall");
            println("\t3. Stein");
            println("\t4. Keramik");
            println("");

            print("Bitte Zahl eingeben: ");
            material = input.nextInt();
            input.nextLine();
            if (material > 0) {
                break;
            }
            println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut");
            println("");
        }



        while (true) {
            println("Geben sie die Anzahl der Türen an :");

            print("Bitte Zahl eingeben: ");
            doors = input.nextInt();
            input.nextLine();
            if (doors > 0) {
                break;
            }
            println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut");
            println("");
        }


        do {
            print("Neigung? (Ja/Nein): ");

            String s = input.nextLine();

            switch (s.toLowerCase()) {
                case "ja":
                    slope = true;
                    break;
                case "nein":
                    slope = false;
                    break;
                default:
                    println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut");
                    println("");
                    continue;
            }
        } while (false);

        println("");
        println("");


        model.getArticleList().add(articleFactory.createCloset(articleId, name,
                                                               price, material,
                                                               doors, slope));

        model.setArticleSearchList(model.getArticleList());

        return SUCCESS;
    }
}
