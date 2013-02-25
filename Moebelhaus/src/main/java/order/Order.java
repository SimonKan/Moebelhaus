package order;

import article.ArticleList;
import article.ConcreteArticle;
import customer.Customer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import misc.UniqueNumberGenerator;
import order.discount.Discount;

/**
 * Eine Bestellung von Artikeln
 *
 * @author Simon
 *
 */
public class Order {

    public static final float TAX = 0.19f;
    private static UniqueNumberGenerator generator = new UniqueNumberGenerator();

    /**
     *
     * @param customer
     *
     * @return Die Order ist leer und hat keinen Preis.
     *
     */
    public static Order create(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("customer was null");
        }

        Order order = new Order();

        order.id = generator.getNextNumber();
        order.customer = customer;
        order.articles = new ArrayList<>();
        order.discounts = new ArrayList<>();
        order.orderingDate = GregorianCalendar.getInstance().getTime();
        order.bookingDate = null;
        order.deliveryDate = null;
        order.price = 0f;

        return order;
    }
    private long id;
    private Customer customer;
    private List<ConcreteArticle> articles;
    private List<Discount> discounts;
    private float price;
    private Date orderingDate;
    private Date bookingDate;
    private Date deliveryDate;

    private Order() {
    }

    /**
     *
     * @return id ID
     */
    public long getId() {
        return this.id;
    }

    public Customer getCustomer() {
        return customer;
    }

    /**
     *
     * @return price Preis
     */
    public float getPrice() {
        price = 0;
        for (ConcreteArticle article : articles) {
            price += article.getArticle().getPrice();
        }
        for (int i = 0; i < discounts.size(); i++) {
            discounts.get(i).apply(this);
        }
        return price;
    }

    /**
     * Hilfsmethode zum Berechnen der Preise für Discounts.
     * @return price Preis
     */
    public float getPricePure() {
        return price;
    }

    /**
     * Methode zum Festlegen des Preises
     * @param price
     */
    public void setPrice(float price) {
        if (price < 0) {
            throw new IllegalArgumentException("price was negative");
        }
        this.price = price;
    }

    /**
     * Erstellung einer Liste.
     * @return
     */
    public List<ConcreteArticle> getArticles() {
        return new ArrayList<>(articles);
    }

    /**
     * Methode zum Hinzufügen eines Aricles
     * @param article
     */
    public void addArticle(ConcreteArticle article) {
        if (!(articles.contains(article))) {
            articles.add(article);
        }
    }

    /**
     *Methode zum hinzufügen eines Discounts
     * @param discount
     */
    public void addDiscount(Discount discount) {
        if (discount == null) {
            throw new IllegalArgumentException("discount was null");
        }

        if (discounts.contains(discount)) {
            discounts.remove(discount);
        }
        discounts.add(discount);
        Collections.sort(discounts);
    }

    /**
     * GetterMethode für Discounts
     * @return Discount 
     */
    public List<Discount> getDiscounts() {
        return new ArrayList<>(discounts);
    }

    /**
     * GetterMethode für das Bestellungsdatum
     * @return orderingDate Tag der Bestellung
     */
    public Date getOrderingDate() {
        return orderingDate;
    }

    /**
     * GetterMethode für den Buchungsstatus
     * @return booked Gebucht oder Nicht
     */
    public boolean isBooked() {
        return bookingDate != null;
    }

    /**
     * GetterMethode für das Buchungsdatum.
     * @return bookingDate Tag der Buchung
     */
    public Date getBookingDate() {
        return bookingDate;
    }

    /**
     * Legt das Buchungsdatum fest
     *
     * @param date
     */
    public void setBookingDate(Date date) {
        if (isBooked()) {
            throw new IllegalStateException("bookingDate already set");
        }
        if (date == null) {
            throw new IllegalArgumentException("date was null");
        }
        if (date.before(orderingDate)) {
            throw new IllegalArgumentException("bookingDate '" + bookingDate
                + "' cannot be before orderingDate '" + orderingDate + "'");
        }
        bookingDate = date;
    }

    /**
     *
     * @return deliveryDate
     */
    public boolean isDelivered() {
        return deliveryDate != null;
    }

    /**
     *
     * @return deliveryDate
     */
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Legt das Lieferdatum fest
     *
     * @param date
     *
     * @ return deliveryDate Lieferdatum
     */
    public void setDeliveryDate(Date date) {
        if (isDelivered()) {
            throw new IllegalStateException("already delivered");
        }
        if (date == null) {
            throw new IllegalArgumentException("date was null");
        }
        if (date.before(orderingDate)) {
            throw new IllegalArgumentException("deliveryDate '" + bookingDate
                + "' cannot be before orderingDate '" + orderingDate + "'");
        }
        deliveryDate = date;
    }
}