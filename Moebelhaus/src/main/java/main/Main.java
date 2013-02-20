/*
 * Main.java
 *
 * Created on 02.02.2013, 19:10:28
 */
package main;

import controller.CustomerController;
import controller.MainNavigator;
import controller.SearchNavigator;
import controller.Controller;
import article.ArticleList;
import customer.AddressGermany;
import customer.Customer;
import customer.CustomerList;
import java.util.regex.Pattern;
import order.OrderList;

/**
 *
 *
 * @author Simon
 * @since 02.02.2013
 * @version 1.0.0
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArticleList articleList = new ArticleList();
        CustomerList customerList = new CustomerList();
        OrderList orderList = new OrderList();
        
        
        customerList.add(Customer.create(AddressGermany.create(
            "Hans", "Lollo", "Saarbrücken", 66111, "Im Flitzepuff", "12")));
        
        customerList.add(Customer.create(AddressGermany.create(
            "Max", "Mustermann", "Saarbrücken", 66111, "Im Flitzepuff", "12")));
        
        customerList.add(Customer.create(AddressGermany.create(
            "Dieter", "Schmitt", "Saarbrücken", 66111, "Im Flitzepuff", "12")));
        
        Model model = new Model(articleList, orderList, customerList);
        
        
        Controller con = new MainNavigator(model);
        SearchNavigator sn = new SearchNavigator(model);
        CustomerController cc = new CustomerController(model);
        
        sn.add(cc);
        con.add(sn);
        
        con.execute(0);
    }
}
