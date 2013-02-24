/*
 * Main.java
 *
 * Created on 02.02.2013, 19:10:28
 */
package main;

import article.ArticleFactory;
import article.Material;
import article.Table;
import controller.MainNavigator;
import controller.article.ArticleNavigator;
import controller.article.ArticlePrintController;
import controller.article.add.ArticleAddBathController;
import controller.article.add.ArticleAddClosetController;
import controller.article.add.ArticleAddCouchController;
import controller.article.add.ArticleAddNavigator;
import controller.article.add.ArticleAddTableController;
import controller.article.search.ArticlePrintSearchController;
import controller.article.search.ArticleSearchByArticleIdController;
import controller.article.search.ArticleSearchByMaterialController;
import controller.article.search.ArticleSearchByNameController;
import controller.article.search.ArticleSearchByPriceController;
import controller.article.search.ArticleSearchNavigator;
import controller.customer.CustomerAddController;
import controller.customer.CustomerNavigator;
import controller.customer.CustomerPrintController;
import controller.customer.CustomerRemoveController;
import controller.customer.search.CustomerPrintSearchController;
import controller.customer.search.CustomerSearchByCityController;
import controller.customer.search.CustomerSearchByFistNameController;
import controller.customer.search.CustomerSearchByLastNameController;
import controller.customer.search.CustomerSearchByPlzController;
import controller.customer.search.CustomerSearchNavigator;
import controller.order.OrderAddArticleController;
import controller.order.OrderAddController;
import controller.order.OrderAddDiscountController;
import controller.order.OrderModifyNavigator;
import controller.order.OrderNavigator;
import controller.order.OrderPrintController;
import controller.order.OrderRemoveController;
import controller.order.search.OrderPrintSearchController;
import controller.order.search.OrderSearchByPriceController;
import controller.order.search.OrderSearchNavigator;
import customer.AddressGermany;
import customer.Customer;
import order.Order;
import order.discount.DiscountFactory;

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
        ArticleFactory articleFactory = new ArticleFactory();

        Model model = GET_DEFAULT_MODEL(articleFactory);

//******************************************************************************
//
//      Article
//
//******************************************************************************

        // Add Articles
        ArticleAddNavigator aan = new ArticleAddNavigator(model);
        aan.add(new ArticleAddBathController(model, articleFactory));
        aan.add(new ArticleAddClosetController(model, articleFactory));
        aan.add(new ArticleAddCouchController(model, articleFactory));
        aan.add(new ArticleAddTableController(model, articleFactory));

        // Search Articles
        ArticleSearchNavigator asn = new ArticleSearchNavigator(model);
        asn.add(new ArticlePrintSearchController(model));
        asn.add(new ArticleSearchByArticleIdController(model));
        asn.add(new ArticleSearchByNameController(model));
        asn.add(new ArticleSearchByPriceController(model));
        asn.add(new ArticleSearchByMaterialController(model));

        // Article Main Menu
        ArticleNavigator an = new ArticleNavigator(model);
        an.add(new ArticlePrintController(model));
        an.add(aan);
        an.add(asn);


//******************************************************************************
// 
//      Customer
// 
//******************************************************************************

        // Search Customers
        CustomerSearchNavigator csn = new CustomerSearchNavigator(model);
        csn.add(new CustomerPrintSearchController(model));
        csn.add(new CustomerSearchByFistNameController(model));
        csn.add(new CustomerSearchByLastNameController(model));
        csn.add(new CustomerSearchByPlzController(model));
        csn.add(new CustomerSearchByCityController(model));

        // Customer Main Menu
        CustomerNavigator cn = new CustomerNavigator(model);
        cn.add(new CustomerPrintController(model));
        cn.add(new CustomerAddController(model));
        cn.add(new CustomerRemoveController(model));
        cn.add(csn);


//******************************************************************************
//
//      Order
//
//******************************************************************************

        // Modify Orders
        OrderModifyNavigator omn = new OrderModifyNavigator(model);
        omn.add(new OrderAddArticleController(model));
        omn.add(new OrderAddDiscountController(model));

        // Search Orders
        OrderSearchNavigator osn = new OrderSearchNavigator(model);
        osn.add(new OrderPrintSearchController(model));
        osn.add(new OrderSearchByPriceController(model));

        // Order Main Menu
        OrderNavigator on = new OrderNavigator(model);
        on.add(new OrderPrintController(model));
        on.add(new OrderAddController(model));
        on.add(new OrderRemoveController(model));
        on.add(omn);
        on.add(osn);


//******************************************************************************
//
//      Main Menu
//
//******************************************************************************

        MainNavigator main = new MainNavigator(model);
        main.add(an);   // Article Main Menu
        main.add(cn);   // Customer Main Menu
        main.add(on);   // Order Main Menu


        main.execute(0);
    }

    private static Model GET_DEFAULT_MODEL(ArticleFactory articleFactory) {
        Model model = Model.create();

        /*
         * Kunden
         */
        model.getCustomerList().add(Customer.create(AddressGermany.create(
            "Reinald", "Böttger", 15526, "Rietz-Neuendorf", "Peter-Vischer-Straße", "17")));

        model.getCustomerList().add(Customer.create(AddressGermany.create(
            "Wally", "Wischnewski", 63920, "Großheubach", "Heringsgraben", "57")));

        model.getCustomerList().add(Customer.create(AddressGermany.create(
            "Herlind", "Albers", 66111, "Meckenbeuren", "Ullersdorfer Straße", "46")));

        model.getCustomerList().add(Customer.create(AddressGermany.create(
            "Burghard", "Georg", 81543, "München", "Grazer Straße", "4")));

        model.getCustomerList().add(Customer.create(AddressGermany.create(
            "Serpil", "Heidt", 53506, "Rech", "Am Knöcklein", "9")));

        model.getCustomerList().add(Customer.create(AddressGermany.create(
            "Dankwart", "Fitz", 74343, "Sachsenheim", "Dora-Stock-Straße", "32b")));

        model.getCustomerList().add(Customer.create(AddressGermany.create(
            "Sibylle", "Brückmann", 57520, "Kausen", "Julius-Scholtz-Straße", "5")));

        model.getCustomerList().add(Customer.create(AddressGermany.create(
            "Aurelia", "Dobler", 19417, "Ventschow", "Alfred-Schmieder-Straße", "18")));

        model.getCustomerList().add(Customer.create(AddressGermany.create(
            "Marco", "Beckers", 91080, "Uttenreuth", "Heymelstraße", "41")));

        model.getCustomerList().add(Customer.create(AddressGermany.create(
            "Anemone", "Manke", 30823, "Garbsen", "Striesener Straße", "38b")));

        model.getCustomerList().add(Customer.create(AddressGermany.create(
            "Gebhart", "Hüttner", 72666, "Neckartailfingen", "Heinrich-Baldes-Straße", "9b")));

        model.getCustomerList().add(Customer.create(AddressGermany.create(
            "Steffan", "Gellert", 18239, "Satow", "Henriette-Heber-Straße", "12c")));

        model.getCustomerList().add(Customer.create(AddressGermany.create(
            "Chuck", "Norris", 77868, "Navasota", "La Grange Avenue", "11872")));


        /*
         * Artikel
         */
        // Bath
        model.getArticleList().add(articleFactory.createBath(1, "Ireviken", 29.99f,
                                                             Material.CERAMIC, false, 1));

        model.getArticleList().add(articleFactory.createBath(1, "Ireviken", 29.99f,
                                                             Material.CERAMIC, false, 1));


        model.getArticleList().add(articleFactory.createBath(2, "Edeboviken", 130.00f,
                                                             Material.CERAMIC, false, 1));

        model.getArticleList().add(articleFactory.createBath(2, "Edeboviken", 130.00f,
                                                             Material.CERAMIC, false, 1));

        model.getArticleList().add(articleFactory.createBath(2, "Edeboviken", 130.00f,
                                                             Material.CERAMIC, false, 1));


        model.getArticleList().add(articleFactory.createBath(3, "Rättviken", 100.00f,
                                                             Material.CERAMIC, false, 1));

        model.getArticleList().add(articleFactory.createBath(3, "Rättviken", 100.00f,
                                                             Material.CERAMIC, false, 1));


        model.getArticleList().add(articleFactory.createBath(4, "Bredviken", 270.00f,
                                                             Material.CERAMIC, false, 1));

        model.getArticleList().add(articleFactory.createBath(4, "Bredviken", 270.00f,
                                                             Material.CERAMIC, false, 1));

        model.getArticleList().add(articleFactory.createBath(4, "Bredviken", 270.00f,
                                                             Material.CERAMIC, false, 1));

        model.getArticleList().add(articleFactory.createBath(4, "Bredviken", 270.00f,
                                                             Material.CERAMIC, false, 1));

        // Table
        model.getArticleList().add(articleFactory.createTable(11, "Bjursta", 129.00f,
                                                              Material.WOOD, true,
                                                              Table.Categories.KITCHENTABLE));

        model.getArticleList().add(articleFactory.createTable(11, "Bjursta", 129.00f,
                                                              Material.WOOD, true,
                                                              Table.Categories.KITCHENTABLE));

        model.getArticleList().add(articleFactory.createTable(11, "Bjursta", 129.00f,
                                                              Material.WOOD, true,
                                                              Table.Categories.KITCHENTABLE));


        model.getArticleList().add(articleFactory.createTable(12, "Björkudden", 89.00f,
                                                              Material.WOOD, false,
                                                              Table.Categories.KITCHENTABLE));

        model.getArticleList().add(articleFactory.createTable(12, "Björkudden", 89.00f,
                                                              Material.WOOD, false,
                                                              Table.Categories.KITCHENTABLE));

        model.getArticleList().add(articleFactory.createTable(12, "Björkudden", 89.00f,
                                                              Material.WOOD, false,
                                                              Table.Categories.KITCHENTABLE));

        model.getArticleList().add(articleFactory.createTable(12, "Björkudden", 89.00f,
                                                              Material.WOOD, false,
                                                              Table.Categories.KITCHENTABLE));

        model.getArticleList().add(articleFactory.createTable(12, "Björkudden", 89.00f,
                                                              Material.WOOD, false,
                                                              Table.Categories.KITCHENTABLE));


        model.getArticleList().add(articleFactory.createTable(13, "Malm", 29.00f,
                                                              Material.WOOD, false,
                                                              Table.Categories.KITCHENTABLE));

        model.getArticleList().add(articleFactory.createTable(13, "Malm", 29.00f,
                                                              Material.WOOD, false,
                                                              Table.Categories.KITCHENTABLE));

        model.getArticleList().add(articleFactory.createTable(13, "Malm", 29.00f,
                                                              Material.WOOD, false,
                                                              Table.Categories.KITCHENTABLE));


        model.getArticleList().add(articleFactory.createTable(14, "Rast", 29.00f,
                                                              Material.WOOD, false,
                                                              Table.Categories.COUCHTABLE));

        model.getArticleList().add(articleFactory.createTable(14, "Rast", 29.00f,
                                                              Material.WOOD, false,
                                                              Table.Categories.COUCHTABLE));

        model.getArticleList().add(articleFactory.createTable(14, "Rast", 29.00f,
                                                              Material.WOOD, false,
                                                              Table.Categories.COUCHTABLE));

        /*
         * Bestellungen
         */
        Order o0 = Order.create(model.getCustomerList().getCustomerById(1));
        Order o1 = Order.create(model.getCustomerList().getCustomerById(3));
        Order o2 = Order.create(model.getCustomerList().getCustomerById(5));

        o0.addArticle(model.getArticleList().getArticleByUniqueId(1));
        o0.addArticle(model.getArticleList().getArticleByUniqueId(2));
        o0.addArticle(model.getArticleList().getArticleByUniqueId(5));

        o0.addDiscount(DiscountFactory.createDiscountThree());

        model.getOrderList().add(o0);
        model.getOrderList().add(o1);
        model.getOrderList().add(o2);

        // Daten kopieren in die Suchlisten
        model.setArticleSearchList(model.getArticleList());
        model.setCustomerSearchList(model.getCustomerList());
        model.setOrderSearchList(model.getOrderList());

        return model;
    }
}
