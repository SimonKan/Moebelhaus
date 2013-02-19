package order;

import article.ConcreteArticle;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import misc.UniqueNumberGenerator;

/**
 * Eine Bestellung von Artikeln
 *
 * @author Simon
 * @param id eine OrderId
 * @param price Preis der Order
 * @param orderingDate Tag der Order
 * @param bookingDate Tag der Buchung
 * @param deliveryDate Tag der Lierferung
 * @param tax Steuern
 *
 * @return Order
 *
 */
public class Order {

    private static UniqueNumberGenerator generator = new UniqueNumberGenerator();

    public static Order create() {
        //TODO create consistency checks for the factory method

        Order order = new Order();

        order.id = generator.getNextNumber();
        order.orderingDate = GregorianCalendar.getInstance().getTime();
        order.bookingDate = null;
        order.deliveryDate = null;
        // TODO initialize price, tax

        return order;
    }
    private long id;
    private List<ConcreteArticle> articles;
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
        return this.price;
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