/*
 * OrderModifyController.java
 *
 * Created on 23.02.2013, 18:09:16
 */
package controller.order;

import controller.Controller;
import main.Model;
import order.Order;
import order.discount.DiscountFactory;

/**
 *
 *
 * @author Simon
 * @since 23.02.2013
 * @version 1.0.0
 *
 */
public class OrderAddDiscountController extends Controller {

    public static final String ESCAPE = "abort";

    public OrderAddDiscountController(Model model) {
        super(model);
    }

    @Override
    public String getName() {
        return "Rabatt hinzufügen";
    }

    @Override
    public String getToken() {
        return "discount";
    }

    @Override
    public void showMenu() {
        println("Hier können Sie Rabatte zu einer Bestellung hinzufügen");
        println("");
    }

    @Override
    protected int read() {
        Order order = null;

        while (true) {
            print("ID der zu bearbeitenden Bestellung: ");
            long id = input.nextLong();
            input.nextLine();
            order = model.getOrderList().getOrderByUniqueId(id);
            if (order != null) {
                break;
            }
            println("(!) Fehlerhafte Eingabe, Order mit ID " + id
                + "existiert nicht");
            println("");
        }

        println("");
        println("Wählen Sie einen hinzuzufügenden Rabatt aus.");

        String in;

        while (true) {
            println("Geben Sie die IDs der hinzuzufügenden Rabatte an und beenden "
                + "Sie den Vorgang mit '" + ESCAPE + "'");
            println("");
            println("\t1) Prozentrabatt");
            println("\t2) Abzug über Grenze");
            println("\t3) Mehrwertsteuer erlassen");
            println("\t4) Fixabzug");
            println("");

            print("Eingabe: ");
            in = input.nextLine();
            if (ESCAPE.equals(in)) {
                break;
            }
            try {
                int id = Integer.parseInt(in);
                switch (id) {
                    case 1:
                        getDiscountOne(order);
                        break;
                    case 2:
                        getDiscountTwo(order);
                        break;
                    case 3:
                        order.addDiscount(DiscountFactory.createDiscountThree());
                        break;
                    case 4:
                        getDiscountFour(order);
                        break;
                    default:
                        println("(!) Fehlerhafte Eingabe, geben Sie eine gültige ID ein");
                        println("");
                        continue;
                }
            } catch (NumberFormatException ex) {
                println("(!) Fehlerhafte Eingabe, geben Sie eine gültige ID ein");
                println("");
                continue;
            }
            println("");
            println("");
        }

        return SUCCESS;
    }

    private void getDiscountOne(Order order) {
        println("Geben Sie bitte die beiden Prozentsätze ein.");
        print("Prozentsatz 1: ");
        int p1 = input.nextInt();
        input.nextLine();
        print("Prozentsatz 2: ");
        int p2 = input.nextInt();
        input.nextLine();

        order.addDiscount(DiscountFactory.createDiscountOne(
            (p1 / 100f), (p2 / 100f)));
    }

    private void getDiscountTwo(Order order) {
        print("Geben Sie die Grenze an: ");
        float threshold = input.nextFloat();
        input.nextLine();
        print("Geben Sie den Abzug an: ");
        float offtake = input.nextFloat();
        input.nextLine();

        order.addDiscount(DiscountFactory.createDiscountTwo(threshold, offtake));
    }

    private void getDiscountFour(Order order) {
        print("Geben Sie den Abzug an: ");
        float offtake = input.nextFloat();
        input.nextLine();

        order.addDiscount(DiscountFactory.createDiscountFour(offtake));
    }
}
