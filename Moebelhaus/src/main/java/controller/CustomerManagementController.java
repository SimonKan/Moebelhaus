/*
 * CustomerManagementController.java
 *
 * Created on 21.02.2013, 13:46:32
 */
package controller;

import article.ArticleList;
import customer.AddressGermany;
import customer.Customer;
import customer.CustomerList;
import java.util.InputMismatchException;
import main.Model;
import order.OrderList;

/**
 *
 *
 * @author Simon
 */
public class CustomerManagementController extends Controller {

    public CustomerManagementController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Kunden bearbeiten";
    }

    @Override
    public String getToken() {
        return "mod";
    }

    @Override
    public void showMenu() {
        println("Wählen Sie aus folgenden Optionen, um Kunden zu bearbeiten");
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
                case "add":
                    String firstName = "";
                    String lastName = "";
                    int plz = 0;
                    String city = "";
                    String street = "";
                    String houseNumber = "";

                    while (true) {
                        print("Vorname:      ");
                        firstName = input.nextLine().trim();
                        if (firstName.matches("[a-zA-Z ]+")) {
                            break;
                        }
                        println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut");
                        println("");
                    }

                    while (true) {
                        print("Nachname:     ");
                        lastName = input.nextLine().trim();
                        if (lastName.matches("[a-zA-Z ]+")) {
                            break;
                        }
                        println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut");
                        println("");
                    }

                    while (true) {
                        print("Postleitzahl: ");
                        try {
                            plz = input.nextInt();
                            input.nextLine();
                            if (plz > 10000 && plz < 100000) {
                                break;
                            }
                        } catch (InputMismatchException ex) {
                            input.skip("\\.*");
                        }
                        println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut");
                        println("");
                    }

                    while (true) {
                        print("Stadt:        ");
                        city = input.nextLine().trim();
                        if (city.matches("[a-zA-Z ]+")) {
                            break;
                        }
                        println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut");
                        println("");
                    }

                    while (true) {
                        print("Straße:       ");
                        street = input.nextLine().trim();
                        if (street.matches("[a-zA-Z ]+")) {
                            break;
                        }
                        println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut");
                        println("");
                    }

                    while (true) {
                        print("Hausnummer:   ");
                        houseNumber = input.nextLine().trim();
                        if (houseNumber.matches("\\d+[a-z]?")) {
                            break;
                        }
                        println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut");
                        println("");
                    }

                    model.getCustomerList().add(Customer.create(
                        AddressGermany.create(firstName, lastName, plz, city,
                                              street, houseNumber)));

                    println("");
                    println("");

                    result = SUCCESS;
                    break;
                case "2":
                case "del":
                    print("ID des zu löschenden Kunden: ");
                    long id;
                    while (true) {
                        try {
                            id = input.nextLong();
                            break;
                        } catch (InputMismatchException ex) {
                            input.skip("\\.*");
                        }
                        println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut");
                        println("");
                    }

                    model.getCustomerList().remove(
                        model.getCustomerList().getCustomerById(id));

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
