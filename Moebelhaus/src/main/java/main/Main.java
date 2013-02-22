/*
 * Main.java
 *
 * Created on 02.02.2013, 19:10:28
 */
package main;

import article.ArticleFactory;
import article.Material;
import article.Table;
import controller.ArticleSearchController;
import controller.CustomerManagementController;
import controller.CustomerSearchController;
import controller.StatisticsController;
import controller.navigator.ArticleNavigator;
import controller.navigator.CustomerNavigator;
import controller.navigator.MainNavigator;
import controller.navigator.OrderNavigator;
import customer.AddressGermany;
import customer.Customer;

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
        Model model = GET_DEFAULT_MODEL();

        CustomerNavigator cn = new CustomerNavigator(model);
        cn.add(new CustomerManagementController(model));
        cn.add(new CustomerSearchController(model));

        OrderNavigator on = new OrderNavigator(model);

        ArticleNavigator an = new ArticleNavigator(model);
        an.add(new ArticleSearchController(model));


        MainNavigator main = new MainNavigator(model);
        main.add(an);
        main.add(cn);
        main.add(on);
        main.add(new StatisticsController(model));

        main.execute(0);
    }

    private static Model GET_DEFAULT_MODEL() {
        Model model = Model.create();



        // Kunden
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



        // Artikel
        ArticleFactory af = new ArticleFactory();


        // Bath
        model.getArticleList().add(af.createBath(1, "Ireviken", 29.99f,
                                                 Material.CERAMIC, false, 1));

        model.getArticleList().add(af.createBath(1, "Ireviken", 29.99f,
                                                 Material.CERAMIC, false, 1));


        model.getArticleList().add(af.createBath(2, "Edeboviken", 130.00f,
                                                 Material.CERAMIC, false, 1));

        model.getArticleList().add(af.createBath(2, "Edeboviken", 130.00f,
                                                 Material.CERAMIC, false, 1));

        model.getArticleList().add(af.createBath(2, "Edeboviken", 130.00f,
                                                 Material.CERAMIC, false, 1));


        model.getArticleList().add(af.createBath(3, "Rättviken", 100.00f,
                                                 Material.CERAMIC, false, 1));

        model.getArticleList().add(af.createBath(3, "Rättviken", 100.00f,
                                                 Material.CERAMIC, false, 1));


        model.getArticleList().add(af.createBath(4, "Bredviken", 270.00f,
                                                 Material.CERAMIC, false, 1));

        model.getArticleList().add(af.createBath(4, "Bredviken", 270.00f,
                                                 Material.CERAMIC, false, 1));

        model.getArticleList().add(af.createBath(4, "Bredviken", 270.00f,
                                                 Material.CERAMIC, false, 1));

        model.getArticleList().add(af.createBath(4, "Bredviken", 270.00f,
                                                 Material.CERAMIC, false, 1));



        // Table
        model.getArticleList().add(af.createTable(11, "Bjursta", 129.00f,
                                                  Material.WOOD, true,
                                                  Table.Categories.category1));

        model.getArticleList().add(af.createTable(11, "Bjursta", 129.00f,
                                                  Material.WOOD, true,
                                                  Table.Categories.category1));

        model.getArticleList().add(af.createTable(11, "Bjursta", 129.00f,
                                                  Material.WOOD, true,
                                                  Table.Categories.category1));


        model.getArticleList().add(af.createTable(12, "Björkudden", 89.00f,
                                                  Material.WOOD, false,
                                                  Table.Categories.category1));

        model.getArticleList().add(af.createTable(12, "Björkudden", 89.00f,
                                                  Material.WOOD, false,
                                                  Table.Categories.category1));

        model.getArticleList().add(af.createTable(12, "Björkudden", 89.00f,
                                                  Material.WOOD, false,
                                                  Table.Categories.category1));

        model.getArticleList().add(af.createTable(12, "Björkudden", 89.00f,
                                                  Material.WOOD, false,
                                                  Table.Categories.category1));

        model.getArticleList().add(af.createTable(12, "Björkudden", 89.00f,
                                                  Material.WOOD, false,
                                                  Table.Categories.category1));


        model.getArticleList().add(af.createTable(13, "Malm", 29.00f,
                                                  Material.WOOD, false,
                                                  Table.Categories.category1));

        model.getArticleList().add(af.createTable(13, "Malm", 29.00f,
                                                  Material.WOOD, false,
                                                  Table.Categories.category1));

        model.getArticleList().add(af.createTable(13, "Malm", 29.00f,
                                                  Material.WOOD, false,
                                                  Table.Categories.category1));


        model.getArticleList().add(af.createTable(14, "Rast", 29.00f,
                                                  Material.WOOD, false,
                                                  Table.Categories.category1));

        model.getArticleList().add(af.createTable(14, "Rast", 29.00f,
                                                  Material.WOOD, false,
                                                  Table.Categories.category1));

        model.getArticleList().add(af.createTable(14, "Rast", 29.00f,
                                                  Material.WOOD, false,
                                                  Table.Categories.category1));


        return model;
    }
}
