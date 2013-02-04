/*
 * Customer.java
 *
 * Created on 02.02.2013, 18:22:28
 */
package customer;

import misc.UniqueNumberGenerator;

/**
 * Customer besitzt AdressGermany und eine Id.
 *
 * @author Simon
 */
public class Customer {

    /*
     * Erstelle Generator um ihn in der statischen Methode verwenden kann.
     * Dieser wird vor dem Programm erstellt.
     * Das Objekt wird erstellt bevor die Main Methode aufgerufen wird.
     */
    private static UniqueNumberGenerator generator = new UniqueNumberGenerator();

    public static Customer create(long id, AddressGermany addressGermany) {

        Customer customer = new Customer();
        customer.id = id;
        customer.addressGermany = addressGermany;
        return customer;
    }
    private long id;
    private AddressGermany addressGermany;

    /*
     * Konstruktor ist privat damit das Programm gezwungen wird die Factory
     * Methode einzusetzen
     */
    private Customer() {
    }

    /*
     * Get Methoden zum Aufruf von AddressGermany und der Id.
     */
    public AddressGermany getAddressGermany() {
        return this.addressGermany;
    }

    public long getId() {
        return this.id;
    }
}