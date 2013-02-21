/*
 * ArticleSearchController.java
 *
 * Created on 21.02.2013, 22:44:14
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
 * @author Simon
 * @since 21.02.2013
 * @version 1.0.0
 */

import article.ArticleList;
import customer.Customer;
import customer.CustomerList;
import main.Model;
import order.OrderList;

/**
 *
 *
 * @author Simon
 *
 */
public class ArticleSearchController extends Controller {

    public ArticleSearchController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Article durchsuchen";
    }

    @Override
    public String getToken() {
        return "search";
    }

    @Override
    public void showMenu() {
        println("Wählen Sie aus folgenden Kriterien, um nach Artikeln zu suchen");
        println("");
        println("\t1) Name (name)");
        println("\t2) Material (mat)");
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
                // FIXME ArticleList#sortById Methode existiert nicht!
                articleList.sortById(true);
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

