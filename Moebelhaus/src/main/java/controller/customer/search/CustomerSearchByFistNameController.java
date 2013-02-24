/*
 * CustomerSearchByFistNameController.java
 *
 * Created on 23.02.2013, 14:18:16
 */
package controller.customer.search;

import controller.Controller;
import main.Model;

/**
 * Controller zum Durchsuchen der Kundenliste anhand des Vornamens.
 *
 * @author Simon
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class CustomerSearchByFistNameController extends Controller {

    public CustomerSearchByFistNameController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Vorname";
    }

    @Override
    public String getToken() {
        return "fname";
    }

    @Override
    public void showMenu() {
    }

    @Override
    protected int read() {
        print("Bitte Vorname eingeben: ");
        String fname = input.nextLine().trim();
        model.setCustomerSearchList(
            model.getCustomerSearchList().getCustomerByFirstName(fname));
        println("");
        println("");

        return SUCCESS;
    }
}
