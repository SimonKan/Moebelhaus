/*
 * CustomerFactory.java
 *
 * Created on 03.02.2013, 23:29:50
 */
package customer;

import main.UniqueNumberGenerator;

/**
 * CustomerFactory erstellt Objekte und vermeidet fehlerhafte Eingaben
 *
 * @author Simon
 * @since 03.02.2013
 * @version 1.0.0
 */
public class CustomerFactory {

    private UniqueNumberGenerator generator2;

    public CustomerFactory() {
        this.generator2 = new UniqueNumberGenerator();
    }

    /**
     *
     */
    /*
     * Für die Klasse AddressGermany existiert ein Konstruktor der bei Fehlerhaften Eingaben eine Fehlermeldung auswirft. 
     * 
     */
    public static AddressGermany create(String firstName, String lastName, String city, int plz, String street, String houseNumber) {
        //Check fistnName
        if (firstName == null) {
            throw new IllegalArgumentException("firstName was null");
        }
        firstName = firstName.trim();
        if (firstName.isEmpty()) {
            throw new IllegalArgumentException("firstName was empty");
        }
        // Check lastName
        if (lastName == null) {
            throw new IllegalArgumentException("lastName was null");
        }
        lastName = lastName.trim();
        if (lastName.isEmpty()) {
            throw new IllegalArgumentException("lastName was empty");
        }
        //Check city
        if (city == null) {
            throw new IllegalArgumentException("city was null");
        }
        city = city.trim();
        if (city.isEmpty()) {
            throw new IllegalArgumentException("city was empty");
        }
        // Check plz
        if (plz < 10000 || plz > 100000) {
            throw new IllegalArgumentException("plz (" + plz + ") illegal");
        }


        //Check street
        if (street == null) {
            throw new IllegalArgumentException("street was null");
        }
        street = street.trim();
        if (street.isEmpty()) {
            throw new IllegalArgumentException("street was empty");
        }
        //Check houseNumber
        if (houseNumber == null) {
            throw new IllegalArgumentException("houseNumber was null");
        }
        lastName = lastName.trim();
        if (lastName.isEmpty()) {
            throw new IllegalArgumentException("houseNumber was empty");
        }
        return null;

    }
}
