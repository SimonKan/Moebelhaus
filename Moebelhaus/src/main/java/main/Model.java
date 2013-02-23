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
 * @since 20.02.2013
 * @version 1.0.0
 *
 * TODO WHY
 */
public class Model {

    public static Model create() {
        Model model = new Model();

        model.articleList = new ArticleList();
        model.articleSearchList = new ArticleList();

        model.customerList = new CustomerList();
        model.customerSearchList = new CustomerList();

        model.orderList = new OrderList();
        model.orderSearchList = new OrderList();

        return model;
    }
    private ArticleList articleList;
    private ArticleList articleSearchList;
    private CustomerList customerList;
    private CustomerList customerSearchList;
    private OrderList orderList;
    private OrderList orderSearchList;

    private Model() {
    }

    public ArticleList getArticleList() {
        return articleList;
    }

    public ArticleList getArticleSearchList() {
        return articleSearchList;
    }

    public void setArticleSearchList(ArticleList articleSearchList) {
        this.articleSearchList = new ArticleList(articleSearchList.toList());
    }

    public CustomerList getCustomerList() {
        return customerList;
    }

    public CustomerList getCustomerSearchList() {
        return customerSearchList;
    }

    public void setCustomerSearchList(CustomerList customerSearchList) {
        this.customerSearchList = new CustomerList(customerSearchList.toList());
    }

    public OrderList getOrderList() {
        return orderList;
    }

    public OrderList getOrderSearchList() {
        return orderSearchList;
    }

    public void setOrderSearchList(OrderList orderSearchList) {
        this.orderSearchList = new OrderList(orderSearchList.toList());
    }
}
