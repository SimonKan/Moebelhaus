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
import controller.order.search.OrderSearchByCustomerIdController;
import controller.order.search.OrderSearchByCustomerNavigator;
import controller.order.search.OrderSearchByPriceController;
import controller.order.search.OrderSearchNavigator;
import controller.statistics.StatisticsNavigator;
import controller.statistics.StatisticsPerformanceController;
import controller.statistics.StatisticsTopCityController;
import controller.statistics.StatisticsTopCustomerController;
import controller.statistics.StatisticsTopNavigator;
import customer.AddressGermany;
import customer.Customer;
import java.util.Date;
import java.util.GregorianCalendar;
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

    /*
     * TODO Liste mit Anmerkungen und Ideen
     *
     * - für irgendwas fehlt noch ein Remove Controller (leider hab ich
     * vergessen für was)
     * PS: Könnte der unten erwähnte Controller sein... :P
     *
     * - Irgendwie müssen Artikel nach dem Kauf (nach dem Bezahlen, Buchen) aus
     * dem Lagerhaus entfernt werden. Allerdings könnte es dann zu einem Problem
     * kommen, wenn ein Artikel in mehreren Bestellungen steht.
     * Eine Möglichkeit wäre, einen Artikel sofort beim Hinzufügen in eine
     * Bestellung aus dem Lagerhaus (model) zu löschen und einen Controller zum
     * Stornieren von Bestellungen hinzuzufügen. Beim Stornieren würden dann die
     * Artikel in der Bestellung zurück ins Lagerhaus transferiert.
     * Alternativ könnte ein Controller zum Löschen von Bestellungen erstellt
     * werden, der beim Löschen die Artikel der Bestellung wieder zurück ins
     * Lagerhaus transferiert.
     * Letzteres könnte mehr Sinn machen, da somit sowohl Stornierungen
     * (unbezahlte Bestellungen) als auch Rücknahmen (bereits bezahlte
     * Bestellungen) möglich wären.
     *
     * - Erläuterung für Simon: Unterschied zwischen JavaDoc und Kommentaren
     * - Erläuterung für Simon: static-Modifier
     * - Erläuterung für Simon: final-Modifier
     *
     * - kleiner Test:
     *
     * 1) Abnahme des Klassendiagramms.
     * Wichtig: Die Entwurfsmuster aufzeigen (!), Zerlegung des
     * Programms in grobe Hauptbestandteile, Relationen zwischen Klassen
     * aufzeigen, komplette Controller-Hierarchie (!).
     *
     * 2) Ein kleines Use-Case Szenario durchspielen (Dabei sollte Simon
     * lediglich zeigen, wie man mit dem Programm umgeht.)
     *
     * 3) Vereinzelte Code Reviews.
     * Wichtig ist abstrakte Fabrik, statische Fabrik, dynamische Fabrik,
     * Fabrikmethode, Sortiermethoden (e.g. bei CustomerList), Method-Chaining
     *
     * 4) Ein (einziger) sequentieller Ablauf (e.g. Suchen eines Kundens nach
     * Vorname).
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArticleFactory articleFactory = new ArticleFactory();

        Model model = GET_DEFAULT_MODEL(articleFactory);


        /*
         * Article
         *
         */
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


        /*
         * Customer
         */
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


        /*
         * Order
         */

        // Modify Orders
        OrderModifyNavigator omn = new OrderModifyNavigator(model);
        omn.add(new OrderAddArticleController(model));
        omn.add(new OrderAddDiscountController(model));

        // Search Orders By Customer Information
        OrderSearchByCustomerNavigator oscn =
            new OrderSearchByCustomerNavigator(model);
        oscn.add(new OrderSearchByCustomerIdController(model));

        // Search Orders
        OrderSearchNavigator osn = new OrderSearchNavigator(model);
        osn.add(new OrderPrintSearchController(model));
        osn.add(oscn);
        osn.add(new OrderSearchByPriceController(model));

        // Order Main Menu
        OrderNavigator on = new OrderNavigator(model);
        on.add(new OrderPrintController(model));
        on.add(new OrderAddController(model));
        on.add(new OrderRemoveController(model));
        on.add(omn);
        on.add(osn);

        /*
         * Statistic
         */

        // Statistics Top Navigator
        StatisticsTopNavigator stn = new StatisticsTopNavigator(model, 5);
        stn.add(new StatisticsTopCustomerController(model, 5));
        stn.add(new StatisticsTopCityController(model, 5));

        // Statistics Main Menu
        StatisticsNavigator sn = new StatisticsNavigator(model);
        sn.add(stn);
        sn.add(new StatisticsPerformanceController(model));

        /*
         * Main Menü
         */

        MainNavigator main = new MainNavigator(model);
        main.add(an);   // Article Main Menu
        main.add(cn);   // Customer Main Menu
        main.add(on);   // Order Main Menu
        main.add(sn);   // Statistis Main Menu


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

        o0.setBookingDate(GregorianCalendar.getInstance().getTime());
        o1.setBookingDate(GregorianCalendar.getInstance().getTime());
        o2.setBookingDate(GregorianCalendar.getInstance().getTime());

        o0.addArticle(model.getArticleList().getArticleByUniqueId(1));
        o0.addArticle(model.getArticleList().getArticleByUniqueId(2));
        o0.addArticle(model.getArticleList().getArticleByUniqueId(5));

        o0.addDiscount(DiscountFactory.createDiscountThree());

        o0.setDeliveryDate(new Date(
            GregorianCalendar.getInstance().getTimeInMillis() + 897232437));

        o1.setDeliveryDate(new Date(
            GregorianCalendar.getInstance().getTimeInMillis() + 782345526));

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
