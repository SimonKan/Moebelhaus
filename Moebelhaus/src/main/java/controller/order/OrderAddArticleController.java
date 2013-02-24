/*
 * OrderAddArticleController.java
 *
 * Created on 23.02.2013, 18:09:16
 */
package controller.order;

import article.ConcreteArticle;
import controller.Controller;
import main.Model;
import order.Order;

/**
 * Controller zum Hinzufügen eines Artikels zu einer schon erstellten Order 
 * anhand der ArtikelId.
 *
 * @author Simon
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class OrderAddArticleController extends Controller {

    public static final String ESCAPE = "OK";

    public OrderAddArticleController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Artikel hinzufügen";
    }

    @Override
    public String getToken() {
        return "article";
    }

    @Override
    public void showMenu() {
        println("Hier können Sie Artikel zu einer Bestellung hinzufügen.");
        println("Wählen Sie zunächst die Bestellung aus, der Artikel");
        println("hinzugefügt werden sollen.");
        println("");
    }

    @Override
    protected int read() {
        Order order = null;

        while (true) {
            print("ID der zu bearbeitenden Bestellung: ");
            long id = input.nextLong();
            input.nextLine();
            order = model.getOrderList().getOrderByUniqueId(id);
            if (order != null) {
                break;
            }
            println("(!) Fehlerhafte Eingabe, Order mit ID " + id
                + "existiert nicht");
            println("");
        }

        println("");
        println("Geben Sie die IDs der hinzuzufügenden Artikel an und beenden "
            + "Sie den Vorgang mit '" + ESCAPE + "'");

        String in;

        while (true) {
            print("Eingabe: ");
            in = input.nextLine();
            if (ESCAPE.toLowerCase().equals(in.toLowerCase())) {
                break;
            }
            try {
                long id = Long.parseLong(in);
                ConcreteArticle article = model.getArticleList().getArticleByUniqueId(id);
                if (article != null) {
                    order.addArticle(article);
                } else {
                    println("(!) Fehlerhafte Eingabe, Artikel existiert nicht");
                    println("");
                }
            } catch (NumberFormatException ex) {
                println("(!) Fehlerhafte Eingabe, geben Sie eine gültige ID ein");
                println("");
                continue;
            }
        }

        return SUCCESS;
    }
}
