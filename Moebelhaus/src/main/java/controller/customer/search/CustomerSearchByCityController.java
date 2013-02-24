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
public class CustomerSearchByCityController extends Controller {

    public CustomerSearchByCityController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Stadt";
    }

    @Override
    public String getToken() {
        return "city";
    }

    @Override
    public void showMenu() {
    }

    @Override
    protected int read() {
        print("Bitte Stadt eingeben: ");
        String city = input.nextLine().trim();
        model.setCustomerSearchList(
            model.getCustomerSearchList().getCustomerByCity(city));
        println("");
        println("");

        return SUCCESS;
    }
}
