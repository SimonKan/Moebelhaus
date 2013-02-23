/*
 * DiscountFactory.java
 *
 * Created on 20.02.2013, 21:00:31
 */
package order.discount;

/**
 *
 *
 * @author Simon
 *
 */
public class DiscountFactory {

    /**
     * Konstruktor der Klasse DiscountOne
     *
     * @param percentage0 Prozentsatz 1
     * @param percentage1 Prozentsatz 2
     *
     * @return {@link Discount DiscountOne}
     *
     * @throws IllegalArgumentException <ul> <li> wenn Prozentsatz1 negativ</li>
     *                                  <li>wenn Prozentsatz2 negativ/li> <ul>
     */
    public static Discount createDiscountOne(float percentage0, float percentage1) {

        // Check Percentage 0
        if (percentage0 <= 0) {
            throw new IllegalArgumentException("percentage was negative or zero");
        }

        //Check Percentage 1
        if (percentage1 <= 0) {
            throw new IllegalArgumentException("percentage was negative or zero");
        }

        return new DiscountOne(percentage0, percentage1);
    }

    /**
     * Konstruktor der Klasse DiscountTwo
     *
     * @param threshold Grenze
     * @param offtake   Abzug
     *
     * @return {@link Discount DiscountTwo}
     *
     * @throws IllegalArgumentException <ul> <li> wenn Grenze negativ</li>
     *                                  <li>wenn Abzug negativ/li> <ul>
     */
    public static Discount createDiscountTwo(float threshold, float offtake) {

        // Check threshold 
        if (threshold <= 0) {
            throw new IllegalArgumentException("threshold was negative ");
        }

        //Check offtake
        if (offtake <= 0) {
            throw new IllegalArgumentException("offtake was negative ");
        }

        return new DiscountOne(threshold, offtake);
    }

    public static Discount createDiscountThree() {
        return new DiscountThree();
    }

    public static Discount createDiscountFour(float offtake) {

        //Check offtake
        if (offtake <= 0) {
            throw new IllegalArgumentException("offtake was negative or zero");
        }

        return new DiscountFour(offtake);
    }
}
