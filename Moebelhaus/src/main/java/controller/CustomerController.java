/*
 * CustomerController.java
 *
 * Created on 20.02.2013, 22:40:10
 */
package controller;

import customer.Customer;
import customer.CustomerList;
import main.Model;

/**
 *
 *
 * @author Immanuel Haffner <s9imhaff@stud.uni-saarland.de>
 * @since 20.02.2013
 * @version 1.0.0
 *
 */
public class CustomerController extends Controller {

    public CustomerController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Kunden";
    }

    @Override
    public String getToken() {
        return "customer";
    }

    @Override
    public void showMenu() {
        println("Wählen Sie aus folgenden Kriterien, um nach Kunden zu suchen");
        println("\t1) Vorname (fname)");
        println("\t2) Nachname (flname)");
        println("");
    }

    @Override
    protected int read() {
        int result = FAILURE;
        CustomerList customerList = model.getCustomerList();
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
            }
            if (result == FAILURE) {
                println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut.");
                println("");
                println("");
            }
            result = FAILURE;
        } while (result == FAILURE);
        return result;
    }
}
