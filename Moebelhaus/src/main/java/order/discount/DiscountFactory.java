/*
 * DiscountFactory.java
 *
 * Created on 20.02.2013, 21:00:31
 */
package order.discount;

import misc.UniqueNumberGenerator;

/**
 *
 *
 * @author Simon
 *
 */
public class DiscountFactory {

    private UniqueNumberGenerator generator;

    public DiscountFactory() {
        this.generator = new UniqueNumberGenerator();
    }

    /**
     * Konstruktor der Klasse DiscountOne
     *
     * @param percentage0 Prozentsatz 1
     * @param percentage1 Prozentsatz 2
     *
     * @return {@link Discount DiscountOne}
     *
     * @throws IllegalArgumentException <ul> <li> wenn Prozentsatz1 negativ</li>
     * <li>wenn Prozentsatz2 negativ/li> <ul>
     */
    public Discount createDiscountOne(float percentage0, float percentage1) {



        // Check Percentage 0 
        if (percentage0 <= 0) {
            throw new IllegalArgumentException("percentage was negative ");
        }

        //Check numberSink
        if (percentage1 <= 0) {
            throw new IllegalArgumentException("percentage was negative ");
        }

        return new Discount(new DiscountOne(percentage0, percentage1), generator.getNextNumber());
    }

    /**
     * Konstruktor der Klasse DiscountTwo
     *
     * @param threshold  Grenze
     * @param offtake  Abzug
     *
     * @return {@link Discount DiscountTwo}
     *
     * @throws IllegalArgumentException <ul> <li> wenn Grenze negativ</li>
     * <li>wenn Abzug negativ/li> <ul>
     */
    public Discount createDiscountTwo(float threshold, float offtake) {



        // Check Percentage 0 
        if (threshold <= 0) {
            throw new IllegalArgumentException("threshold was negative ");
        }

        //Check numberSink
        if (offtake <= 0) {
            throw new IllegalArgumentException("offtake was negative ");
        }

        return new Discount(new DiscountOne(threshold, offtake), generator.getNextNumber());
    }
    
     public Discount createDiscountThree(float threshold, float offtake) {



        return new Discount(new DiscountThree(), generator.getNextNumber());
    }
     
     public Discount createDiscountFour(float offtake) {

        //Check numberSink
        if (offtake <= 0) {
            throw new IllegalArgumentException("offtake was negative ");
        }

        return new Discount(new DiscountFour(offtake), generator.getNextNumber());
    }
}

