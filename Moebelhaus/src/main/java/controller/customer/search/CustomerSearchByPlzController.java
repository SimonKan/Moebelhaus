/*
 * CustomerSearchByFistNameController.java
 *
 * Created on 23.02.2013, 14:18:16
 */
package controller.customer.search;

import controller.Controller;
import main.Model;

/**
 *
 *
 * @author Simon
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class CustomerSearchByPlzController extends Controller {

    public CustomerSearchByPlzController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Postleitzahl";
    }

    @Override
    public String getToken() {
        return "plz";
    }

    @Override
    public void showMenu() {
    }

    @Override
    protected int read() {
        print("Bitte Postleitzahl eingeben: ");
        int plz = input.nextInt();
        input.nextLine();
        model.setCustomerSearchList(
            model.getCustomerSearchList().getCustomerByPlz(plz));
        println("");
        println("");

        return SUCCESS;
    }
}
