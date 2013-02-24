/*
 * CustomerSearchByFistNameController.java
 *
 * Created on 23.02.2013, 14:18:16
 */
package controller.order.search;

import controller.Controller;
import main.Model;

/**
 * Controller zum Durchsuchen der Orderliste nach dem OrderPreis.
 *
 * @author Simon
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class OrderSearchByPriceController extends Controller {

    public OrderSearchByPriceController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Preis";
    }

    @Override
    public String getToken() {
        return "price";
    }

    @Override
    public void showMenu() {
    }

    @Override
    protected int read() {
        print("Bitte Preisuntergrenze eingeben: ");
        float lowerBound = input.nextFloat();
        input.nextLine();
        print("Bitte Preisobergrenze eingeben: ");
        float upperBound = input.nextFloat();
        input.nextLine();
        model.setOrderSearchList(
            model.getOrderSearchList().getOrdersByPrice(lowerBound, upperBound));
        println("");
        println("");

        return SUCCESS;
    }
}
