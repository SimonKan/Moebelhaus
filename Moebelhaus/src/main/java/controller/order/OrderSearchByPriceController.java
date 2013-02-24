/*
 * CustomerSearchByFistNameController.java
 *
 * Created on 23.02.2013, 14:18:16
 */
package controller.order;

import controller.article.*;
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
        Long lowerBound = input.nextLong();
        print("Bitte Preisobergrenze eingeben: ");
        Long upperBound = input.nextLong();
        model.setOrderSearchList(
                model.getOrderSearchList().getOrdersByPrice(lowerBound, upperBound));
        println("");
        println("");

        return SUCCESS;
    }
}
