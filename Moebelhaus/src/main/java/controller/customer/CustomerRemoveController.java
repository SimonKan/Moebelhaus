/*
 * CustomerAddController.java
 *
 * Created on 23.02.2013, 14:04:00
 */
package controller.customer;

import controller.Controller;
import java.util.InputMismatchException;
import main.Model;

/**
 *
 *
 * @author Simon
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class CustomerRemoveController extends Controller {

    public CustomerRemoveController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Kunde entfernen";
    }

    @Override
    public String getToken() {
        return "del";
    }

    @Override
    public void showMenu() {
    }

    @Override
    protected int read() {
        print("ID des zu löschenden Kunden: ");
        long id;
        while (true) {
            try {
                id = input.nextLong();
                break;
            } catch (InputMismatchException ex) {
            }
            println("(!) Fehlerhafte Eingabe, versuchen Sie es erneut");
            println("");
            input.skip("\\.*");
        }

        println("");
        println("");

        model.getCustomerList().remove(
            model.getCustomerList().getCustomerById(id));

        model.setCustomerSearchList(model.getCustomerList());

        return SUCCESS;
    }
}
