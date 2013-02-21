/*
 * ArticleManagementController.java
 *
 * Created on 21.02.2013, 22:40:01
 */
package controller;

import article.ArticleList;
import customer.CustomerList;
import article.Article;
import article.ConcreteArticle;
import java.util.InputMismatchException;
import main.Model;
import order.OrderList;

/**
 *
 *
 * @author Simon
 * @since 21.02.2013
 * @version 1.0.0
 */
public class ArticleManagementController extends Controller {

    public ArticleManagementController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Artikel bearbeiten";
    }

    @Override
    public String getToken() {
        return "mod";
    }

    @Override
    public void showMenu() {
        println("Wählen Sie aus folgenden Optionen, um Artikel zu bearbeiten");
        println("");
        println("\t1) Hinzufügen (add)");
        println("\t2) Löschen (del)");
        println("");
    }

    @Override
    protected int read() {
        int result = FAILURE;
        CustomerList customerList = model.getCustomerList();
        ArticleList articleList = model.getArticleList();
        OrderList orderList = model.getOrderList();
        showMenu();
        do {
            print("Eingabe: ");
            String in = input.next();
            if ("exit".equals(in)) {
                return EXIT;
            }
            if ("abort".equals(in)) {
                return ABORT;
            }
            if ("help".equals(in)) {
                println("");
                println("");
                showMenu();
                continue;
            }
            if ("print".equals(in)) {
                println("");
                for (ConcreteArticle a : articleList.toList()) {
                    println(a.toString());
                }
                println("");
                continue;
            }
            switch (in.toLowerCase()) {
                case "add":
                    String name = "";
                    int material = 0;
                    float price = 0f;


                    // TODO
                    // FIXME
                    while (true) {
                        print("Vorname:      ");
                        name = input.next();
                        if (name.matches("[a-zA-Z]+")) {
                            break;
                        }
                        println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut");
                        println("");
                    }



                    while (true) {
                        print("Material: ");
                        try {
                            material = input.nextInt();
                            if (material < 4) {
                                break;
                            }
                        } catch (InputMismatchException ex) {
                            input.skip("\.*");
                        }
                        println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut");
                        println("");
                    }

                    while (true) {
                        print("Preis: ");
                        try {
                            price = input.nextInt();
                            if (price < 0) {
                                break;
                            }
                        } catch (InputMismatchException ex) {
                            input.skip("\.*");
                        }
                        println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut");
                        println("");
                    }





                    model.getArticleList().add(Article.create(name, material, price));

                    println("");
                    println("");

                    result = SUCCESS;
                    break;
                case "del":
                    print("ID des zu löschenden Artikels: ");
                    long id;
                    while (true) {
                        try {
                            id = input.nextLong();
                            break;
                        } catch (InputMismatchException ex) {
                            input.skip("\.*");
                        }
                        println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut");
                        println("");
                    }

                    model.getArticleList().remove(
                            model.getArticleList().getArticleById(id));

                    println("");
                    println("");

                    result = SUCCESS;
                    break;
                default:
                    println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut.");
                    println("");
                    println("");
            }
        } while (true);
    }
}
