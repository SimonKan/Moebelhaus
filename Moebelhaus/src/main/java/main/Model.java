/*
 * Model.java
 *
 * Created on 20.02.2013, 22:30:51
 */
package main;

import article.ArticleList;
import customer.CustomerList;
import order.OrderList;

/**
 *
 *
 * @author Simon
 *
 * TODO WHY :D
 */
public class Model {

    public static Model create() {
        Model model = new Model();

        model.articleList = new ArticleList();
        model.customerList = new CustomerList();
        model.orderList = new OrderList();

        return model;
    }
    private ArticleList articleList;
    private OrderList orderList;
    private CustomerList customerList;

    private Model() {
    }

    public ArticleList getArticleList() {
        return articleList;
    }

    public OrderList getOrderList() {
        return orderList;
    }

    public CustomerList getCustomerList() {
        return customerList;
    }
}
