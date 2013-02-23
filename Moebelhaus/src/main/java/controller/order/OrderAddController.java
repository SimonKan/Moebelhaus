/*
 * OrderAddController.java
 *
 * Created on 23.02.2013, 16:41:02
 */
package controller.order;

import controller.Controller;
import main.Model;

/**
 *
 *
 * @author Immanuel Haffner <s9imhaff@stud.uni-saarland.de>
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class OrderAddController extends Controller {

    public OrderAddController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Bestellung hinzufügen";
    }

    @Override
    public String getToken() {
        return "add";
    }

    @Override
    public void showMenu() {
        println("Füllen Sie die folgenden Felder aus.");
    }

    @Override
    protected int read() {
        
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
