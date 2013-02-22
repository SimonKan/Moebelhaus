/*
 * CustomerSearchController.java
 *
 * Created on 20.02.2013, 22:40:10
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
 *
 */
public class CustomerSearchController extends Controller {

    public CustomerSearchController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Kunden durchsuchen";
    }

    @Override
    public String getToken() {
        return "search";
    }

    @Override
    public void showMenu() {
        println("Wählen Sie aus folgenden Kriterien, um nach Kunden zu suchen");
        println("");
        println("\t1) Vorname (fname)");
        println("\t2) Nachname (lname)");
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
            String in = input.nextLine();
            in = in.split("\\s+")[0];

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
                customerList.sortByUniqueId(true);
                for (Customer c : customerList.toList()) {
                    println(c.toString());
                }
                println("");
                continue;
            }
            switch (in.toLowerCase()) {
                case "1":
                case "fname":
                    print("Bitte Vorname eingeben: ");
                    String fname = input.nextLine().trim();
                    customerList = customerList.getCustomerByFirstName(fname);
                    println("");
                    println("");

                    result = SUCCESS;
                    break;
                case "2":
                case "lname":
                    print("Bitte Nachname eingeben: ");
                    String lname = input.nextLine().trim();
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
