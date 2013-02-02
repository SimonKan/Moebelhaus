package main;

import java.util.Date;
import order.discount.Discount;

public class Statistics {

    private CustomerList customerList;

    /**
     *
     * @param customerlist
     * @param date
     */
    public int getCustomerByDate(CustomerList customerlist, Date date) {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param customerlist
     * @param dateOne
     * @param dateTwo
     */
    public int getCustomerByTimeline(CustomerList customerlist, Date dateOne, Date dateTwo) {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param customerlist
     * @param price
     */
    public float getPriceByDate(CustomerList customerlist, float price) {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param customerlist
     * @param tax
     * @param dateOne
     * @param dateTwo
     * @param Date
     */
    public float getTaxesByTimeline(CustomerList customerlist, float tax, Date dateOne, int dateTwo, int Date) {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param customerlist
     * @param discounts
     * @param dateOne
     * @param dateTwo
     */
    public float getDiscountsByTimeline(CustomerList customerlist, Discount discounts, Date dateOne, Date dateTwo) {
        throw new UnsupportedOperationException();
    }
}