/*
 * OrderList.java
 *
 * Created on 20.02.2013, 22:31:41
 */
package order;

import article.ArticleList;
import article.ConcreteArticle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author Simon
 */
public class OrderList {

    private List<Order> orders;
// Liste wird erstellt

    public OrderList() {
        orders = new ArrayList<>();
    }

    /**
     *
     * neuer Konstruktor zum Übertragen der {@link List} in eine
     * {@link ArticleList}.
     *
     * @param orders
     */
    public OrderList(List<Order> orders) {
        if (orders == null) {
            throw new IllegalArgumentException("orders was null");
        }
        this.orders = new ArrayList<>(orders);
    }

    /**
     *
     * @param order
     *
     * @return {@code true} wenn der Artikel neu zur Liste hinzukam,
     *         {@code false} falls der Artikel bereits in der Liste ist
     *
     * @throws IllegalArgumentException <ul>
     *                                  <li>if article is null</li>
     *                                  </ul>
     */
    public boolean add(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("order was null");
        }
        if (!orders.contains(order)) {
            orders.add(order);
            return true;
        }
        return false;
    }

    /**
     *
     * @param order der Artikel der aus der Liste zu entfernen ist
     *
     * @return {@code true} wenn der Artikel zuvor in der Liste war,
     *         {@code false} sonst
     */
    public boolean remove(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("order was null");
        }
        return orders.remove(order);
    }

    /**
     *
     * @param order ein Artikel
     *
     * @return {@code true} wenn der Artikel in der Liste ist, {@code false}
     *         sonst
     */
    public boolean contains(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("order was null");
        }
        return orders.contains(order);
    }

    public void sortByPrice(final boolean ascendent) {
        Collections.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                int r = (int) Math.signum(o1.getPrice() - o2.getPrice());
                if(ascendent) {
                    return r;
                }
                return -r;
            }
        });
    }

    public void sortByOrderingDate() {
    }

    /**
     * Durchsucht die Artikelliste nach einem Artikel anhand der UniqueId
     *
     * @param id
     *
     * @return
     *
     * UID existiert
     */
    public Order getOrderByUniqueId(long id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    /**
     * Preis wird um eine Lower und eine UpperBound ergänzt um Preisabschnitte
     * suchen zu können wird die Grenze falsch gewählt gibt das System eine
     * Fehlermeldung aus. Alle Preise größer etwas können durch die Suche nach
     * der oberen Grenze unendlich getätigt werden.
     *
     * @param lowerBound obere Grenze des Preises
     * @param upperBound untere Grenze des Preises
     *
     * @return
     *
     * @throws IllegalArgumentException <ul><li>wenn untere Schranke falsch
     *                                  ist</li><li>wenn oberer Schranke falsch ist</li><ul>
     */
    public OrderList getOrdersByPrice(float lowerBound, float upperBound) {
        if (Float.isNaN(lowerBound)) {
            throw new IllegalArgumentException("lowerBound was NaN");
        }
        if (Float.isNaN(upperBound)) {
            throw new IllegalArgumentException("upperBound was NaN");
        }

        OrderList searchList = new OrderList();

        for (Order order : orders) {
            if (lowerBound <= order.getPrice()
                || order.getPrice() <= upperBound) {
                searchList.add(order);
            }
        }

        return searchList;
    }

    public OrderList getOrdersByOrderingDate(Date lowerBound, Date upperBound) {
        if (lowerBound == null) {
            throw new IllegalArgumentException("lowerBound was null");
        }
        if (upperBound == null) {
            throw new IllegalArgumentException("upperBound was null");
        }

        OrderList searchList = new OrderList();

        for (Order order : orders) {
            if (lowerBound.before(order.getOrderingDate())
                && order.getOrderingDate().before(upperBound)) {
                searchList.add(order);
            }
        }

        return searchList;
    }

    public OrderList getOrdersByBookingDate(Date lowerBound, Date upperBound) {
        if (lowerBound == null) {
            throw new IllegalArgumentException("lowerBound was null");
        }
        if (upperBound == null) {
            throw new IllegalArgumentException("upperBound was null");
        }

        OrderList searchList = new OrderList();

        for (Order order : orders) {
            if (lowerBound.before(order.getBookingDate())
                && order.getBookingDate().before(upperBound)) {
                searchList.add(order);
            }
        }

        return searchList;
    }

    public OrderList getOrdersByDeliveryDate(Date lowerBound, Date upperBound) {
        if (lowerBound == null) {
            throw new IllegalArgumentException("lowerBound was null");
        }
        if (upperBound == null) {
            throw new IllegalArgumentException("upperBound was null");
        }

        OrderList searchList = new OrderList();

        for (Order order : orders) {
            if (lowerBound.before(order.getDeliveryDate())
                && order.getDeliveryDate().before(upperBound)) {
                searchList.add(order);
            }
        }

        return searchList;
    }

    /**
     * Erzeugt eine Arraylist bestehend aus Articles
     *
     * @return {@link List<Concrete Article>}
     */
    public List<Order> toList() {
        return new ArrayList<>(orders);
    }
}
