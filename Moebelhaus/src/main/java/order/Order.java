package order;

import article.ConcreteArticle;
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

    private static UniqueNumberGenerator generator = new UniqueNumberGenerator();

    /**
     *
     * @return Die Order ist leer und hat keinen Preis.
     *
     */
    public static Order create() {

        Order order = new Order();

        order.id = generator.getNextNumber();
        order.orderingDate = GregorianCalendar.getInstance().getTime();
        order.bookingDate = null;
        order.deliveryDate = null;
        order.tax = 0.19f;
        order.price = 0f;

        return order;
    }
    private long id;
    private List<ConcreteArticle> articles;
    private List<Discount> discounts;
    private float price;
    private Date orderingDate;
    private Date bookingDate;
    private Date deliveryDate;
    private float tax;

    private Order() {
    }

    /**
     *
     * @return id ID
     */
    public long getId() {
        return this.id;
    }

    /**
     *
     * @return price Preis
     */
    public float getPrice() {
        float sum = 0f;
        for(ConcreteArticle article : articles) {
            sum += article.getArticle().getPrice();
        }
        sum += sum * tax;
        
        return sum;
    }

    /**
     *
     * @return orderingDate Tag der Bestellung
     */
    public Date getOrderingDate() {
        return orderingDate;
    }

    /**
     *
     * @return booked Gebucht oder Nicht
     */
    public boolean isBooked() {
        return bookingDate != null;
    }

    /**
     *
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