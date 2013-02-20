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
 * @author Immanuel Haffner <s9imhaff@stud.uni-saarland.de>
 * @since 20.02.2013
 * @version 1.0.0
 *
 */
public class Model {

    private final ArticleList articleList;
    private final OrderList orderList;
    private final CustomerList customerList;

    public Model(ArticleList articleList, OrderList orderList,
                 CustomerList customerList) {
        this.articleList = articleList;
        this.orderList = orderList;
        this.customerList = customerList;
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
