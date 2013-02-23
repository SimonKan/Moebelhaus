/*
 * OrderModifyController.java
 *
 * Created on 23.02.2013, 18:09:16
 */
package controller.order;

import article.ConcreteArticle;
import controller.Controller;
import main.Model;
import order.Order;

/**
 *
 *
 * @author Immanuel Haffner <s9imhaff@stud.uni-saarland.de>
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class OrderModifyController extends Controller {

    public static final String ESCAPE = "~";

    public OrderModifyController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Bestellungen bearbeiten";
    }

    @Override
    public String getToken() {
        return "mod";
    }

    @Override
    public void showMenu() {
        println("Hier können Sie Bestellungen bearbeiten");
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
                model.getOrderList().remove(order);
                break;
            }
            println("(!) Fehlerhafte Eingabe, Order mit ID " + id
                + "existiert nicht");
            println("");
        }

        println("");
        println("Geben Sie die IDs der hinzuzufügenden Artikel an und beenden "
            + "Sie den Vorgang mit '" + ESCAPE + "'");

        String in = "";

        while (true) {
            print("Eingabe: ");
            in = input.nextLine();
            if (ESCAPE.equals(in)) {
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
