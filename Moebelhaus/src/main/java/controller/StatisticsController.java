/*
 * StatisticsController.java
 *
 * Created on 21.02.2013, 13:10:38
 */
package controller;

import article.ArticleList;
import customer.Customer;
import customer.CustomerList;
import main.Model;
import order.OrderList;

/**
 *
 *
 * @author Immanuel Haffner <s9imhaff@stud.uni-saarland.de>
 * @since 21.02.2013
 * @version 1.0.0
 *
 */
public class StatisticsController extends Controller {

    public StatisticsController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Statistik";
    }

    @Override
    public String getToken() {
        return "stats";
    }

    @Override
    public void showMenu() {
        println("Statistiken");
        println("Folgende Kriterien:");
        println("");
        println("\t1) Noch garnix! (fname)");
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
                for (Customer c : customerList.toList()) {
                    println(c.toString());
                }
                println("");
                continue;
            }
            switch (in.toLowerCase()) {
                case "fname":
                    print("Bitte Vorname eingeben: ");
                    String fname = input.next();
                    customerList = customerList.getCustomerByFirstName(fname);
                    println("");
                    println("");

                    result = SUCCESS;
                    break;
                case "lname":
                    print("Bitte Nachname eingeben: ");
                    String lname = input.next();
                    customerList = customerList.getCustomerByLastName(lname);
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
