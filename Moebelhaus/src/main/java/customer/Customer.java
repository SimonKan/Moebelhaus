/*
 * Customer.java
 *
 * Created on 02.02.2013, 18:22:28
 */
package customer;

import misc.UniqueNumberGenerator;

/**
 * Diese Klasse repräsentiert einen Kunden. Ein Kunde besitzt eine eindeutide
 * Identifizierungsnummer und eine {@link AddressGermany Adresse}.
 *
 * @author Simon
 */
public class Customer {

    /*
     * Erstelle Generator um ihn in der statischen Methode create(...) verwenden
     * zu können.
     * Das Objekt wird erstellt bevor die Main Methode aufgerufen wird.
     */
    private static UniqueNumberGenerator generator = new UniqueNumberGenerator();

    /**
     *
     * @param addressGermany die Adresse des zu erstellenden Kunden
     *
     * @return ein {@link Customer Kunde} mit der angegebenen Adresse und eine
     *         UID
     * 
     * TODO @link für Adresse ;)
     */
    public static Customer create(AddressGermany addressGermany) {

        Customer customer = new Customer();
        customer.id = generator.getNextNumber();
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

    // TODO JavaDoc
    public long getId() {
        return this.id;
    }
}