/*
 * CustomerAddController.java
 *
 * Created on 23.02.2013, 14:04:00
 */
package controller.customer;

import controller.Controller;
import customer.AddressGermany;
import customer.Customer;
import main.Model;

/**
 * Controller zum Hinzufügen eines Kunden anhand der gegebenen eindeutigen
 * Merkmale.
 *
 * @author Simon
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class CustomerAddController extends Controller {

    public CustomerAddController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Kunde hinzufügen";
    }

    @Override
    public String getToken() {
        return "add";
    }

    @Override
    public void showMenu() {
        println("Bitte füllen Sie die folgenden Felder aus.");
        println("");
    }

    @Override
    protected int read() {
        String fname = "";
        String lname = "";
        int plz = 0;
        String city = "";
        String street = "";
        String houseNumber = "";

        while (true) {
            print("Vorname:      ");
            fname = input.nextLine().trim();
            if (fname.matches("[a-zA-Z][a-zA-Z ]*")) {
                break;
            }
            println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut");
            println("");
        }

        while (true) {
            print("Nachname:     ");
            lname = input.nextLine().trim();
            if (lname.matches("[a-zA-Z]+")) {
                break;
            }
            println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut");
            println("");
        }

        while (true) {
            print("Postleitzahl: ");
            plz = input.nextInt();
            input.nextLine();
            if (10000 <= plz && plz <= 100000) {
                break;
            }
            println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut");
            println("");
        }

        while (true) {
            print("Stadt:        ");
            city = input.nextLine().trim();
            if (city.matches("[a-zA-Z][a-zA-Z ]*")) {
                break;
            }
            println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut");
            println("");
        }

        while (true) {
            print("Straße:       ");
            street = input.nextLine().trim();
            if (street.matches("[a-zA-Z][a-zA-Z \\-]*")) {
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

        println("");
        println("");

        model.getCustomerList().add(Customer.create(
            AddressGermany.create(fname, lname, plz, city,
                                  street, houseNumber)));

        model.setCustomerSearchList(model.getCustomerList());

        return SUCCESS;
    }
}
