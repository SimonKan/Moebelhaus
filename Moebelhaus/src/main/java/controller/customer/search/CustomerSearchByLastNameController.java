/*
 * CustomerSearchByFistNameController.java
 *
 * Created on 23.02.2013, 14:18:16
 */
package controller.customer.search;

import controller.Controller;
import main.Model;

/**
 * Controller zum Durchsuchen der Kundenliste anhand des Nachnamens. 
 *
 * @author Simon
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class CustomerSearchByLastNameController extends Controller {

    public CustomerSearchByLastNameController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Nachname";
    }

    @Override
    public String getToken() {
        return "lname";
    }

    @Override
    public void showMenu() {
    }

    @Override
    protected int read() {
        print("Bitte Nachname eingeben: ");
        String lname = input.nextLine().trim();
        model.setCustomerSearchList(
            model.getCustomerSearchList().getCustomerByLastName(lname));
        println("");
        println("");

        return SUCCESS;
    }
}
