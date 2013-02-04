package order;

import article.ConcreteArticle;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import misc.UniqueNumberGenerator;

public class Order {

    private static UniqueNumberGenerator generator = new UniqueNumberGenerator();

    public static Order create() {
        //TODO
        // consistency checks

        Order order = new Order();

        //TODO
        // initialize members
        order.id = generator.getNextNumber();
        order.orderingDate = GregorianCalendar.getInstance().getTime();
        order.bookingDate = null;
        order.deliveryDate = null;

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

    public long getId() {
        return this.id;
    }

    public float getPrice() {
        return this.price;
    }

    public Date getOrderingDate() {
        return orderingDate;
    }

    public boolean isBooked() {
        return bookingDate != null;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

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

    public boolean isDelivered() {
        return deliveryDate != null;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }
    
    public void setDeliveryDate(Date date) {
        // TODO implement this shit
        throw new UnsupportedOperationException();
    }
}