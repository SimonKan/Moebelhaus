package customer;

import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CustomerList {

    private List<Customer> customers;
// Liste wird erstellt

    public CustomerList() {
        customers = new ArrayList<Customer>();
    }

    /**
     *
     * neuer Konstruktor zum Übertragen der List<Customer> in eine
     * {@link ArticleList}.
     *
     * @param articles Kunden der Liste
     */
    public CustomerList(List<Customer> customer) {
        if (customer == null) {
            throw new IllegalArgumentException("customer was null");
        }
        this.customers = new ArrayList<Customer>(customer);
    }

    /**
     *
     * @param customer ein neuer Kunde
     *
     * @return {@code true} wenn der Kunde neu zur Liste hinzukam, {@code false}
     * falls der Kunde bereits in der Liste ist
     */
    public boolean add(Customer customer) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    /**
     *
     * @param customer der Kunde der aus der Liste zu entfernen ist
     *
     * @return {@code true} wenn der Kunde zuvor in der Liste war, {@code false}
     * sonst
     */
    public boolean remove(Customer customer) {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param customer ein Kunde
     *
     * @return {@code true} wenn der Artikel in der Liste ist, {@code false}
     * sonst
     */
    public boolean contains(Customer customer) {
        throw new UnsupportedOperationException();
    }

    /*
     * Methoden zum Durchsuchen der Liste nach uniqueId, articleId, name,
     * material, price Rückgabetyp jeweils eine neue Liste die mit den Elementen
     * gefüllt wird
     */
    /**
     * Durchsucht die Kundenliste nach einem Kunden anhand der UniqueId
     *
     * @param id
     * @return {@link Customer customer}
     */
    public Customer getCustomerById(long id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    /**
     * Durchsucht die CustomerList anhand des FirstName und gibt eine Liste der
     * Customer zurück
     *
     * @param firstName Name des Customers
     * @return {@link CustomerList searchlist}
     * @throws IllegalArgumentException <ul><li>wenn FirstName null
     * ist</li><li>wenn FirstName leer ist</li><ul>
     */
    public CustomerList getCustomerByFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("name was null");
        }
        firstName = firstName.trim().toLowerCase();
        if (firstName.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        List<Customer> searchList = new ArrayList<Customer>();


        return new CustomerList(searchList);
    }

    /**
     * Durchsucht die CustomerListe anhand des LastName und gibt eine Liste der
     * Customer zurück
     *
     * @param lastName Name des Customer
     * @return {@link Customerlist searchlist}
     * @throws IllegalArgumentException <ul><li>wenn LastName null
     * ist</li><li>wenn LastName leer ist</li><ul>
     */
    public CustomerList getCustomerByLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("lastName was null");
        }
        lastName = lastName.trim().toLowerCase();
        if (lastName.isEmpty()) {
            throw new IllegalArgumentException("lastName is empty");
        }
        List<Customer> searchList = new ArrayList<Customer>();



        return new CustomerList(searchList);
    }

    /**
     * Durchsucht die CustomerListe anhand der Stadt und gibt eine Liste der
     * Customer zurück
     *
     * @param city Stadt des Customer
     * @return {@link Customerlist searchlist}
     * @throws IllegalArgumentException <ul><li>wenn Stadt null ist</li><li>wenn
     * Stadt leer ist</li><ul>
     */
    public CustomerList getCustomerByCity(String city) {
        if (city == null) {
            throw new IllegalArgumentException("city was null");
        }
        city = city.trim().toLowerCase();
        if (city.isEmpty()) {
            throw new IllegalArgumentException("city is empty");
        }
        List<Customer> searchList = new ArrayList<Customer>();



        return new CustomerList(searchList);
    }

    /**
     * Durchsucht die CustomerListe anhand der Straße und gibt eine Liste der
     * Customer zurück
     *
     * @param street Straße Customer
     * @return {@link Customerlist searchlist}
     * @throws IllegalArgumentException <ul><li>wenn Straße null
     * ist</li><li>wenn Straße leer ist</li><ul>
     */
    public CustomerList getCustomerByStreet(String street) {
        if (street == null) {
            throw new IllegalArgumentException("street was null");
        }
        street = street.trim().toLowerCase();
        if (street.isEmpty()) {
            throw new IllegalArgumentException("street is empty");
        }
        List<Customer> searchList = new ArrayList<Customer>();



        return new CustomerList(searchList);
    }

    public List<Customer> toList() {
        return new ArrayList<Customer>(customers);
    }
}
