package customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import order.Order;

/**
 * Klasse CustomerList enthält alle Customer.
 *
 * @author Simon
 */
public class CustomerList {

    private List<Customer> customers;
// Liste wird erstellt

    /**
     * Konstruktor der Klasse CustomerList erzeugt die Liste.
     *
     */
    public CustomerList() {
        customers = new ArrayList<>();
    }

    /**
     *
     * neuer Konstruktor zum Übertragen der List<Customer> in eine
     * {@link ArticleList}.
     *
     * @param customer Kunden der Liste
     *
     */
    public CustomerList(List<Customer> customer) {
        if (customer == null) {
            throw new IllegalArgumentException("customer was null");
        }
        this.customers = new ArrayList<>(customer);
    }

    /**
     *
     * @param customer ein neuer Kunde
     *
     * @return {@code true} wenn der Kunde neu zur Liste hinzukam, {@code false}
     *         falls der Kunde bereits in der Liste ist
     */
    public boolean add(Customer customer) {
        boolean b = !customers.contains(customer);
        if (b) {
            customers.add(customer);
        }
        return b;
    }

    /**
     *
     * @param customer der Kunde der aus der Liste zu entfernen ist
     *
     * @return {@code true} wenn der Kunde zuvor in der Liste war, {@code false}
     *         sonst
     */
    public boolean remove(Customer customer) {
        return customers.remove(customer);
    }

    /**
     *
     * @param customer ein Kunde
     *
     * @return {@code true} wenn der Artikel in der Liste ist, {@code false}
     *         sonst
     */
    public boolean contains(Customer customer) {
        return customers.contains(customer);
    }

    public void sortByUniqueId(final boolean ascendent) {

        Collections.sort(customers, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                int r = (int) (o1.getId() - o2.getId());
                if (ascendent) {
                    return r;
                }
                return -r;
            }
        });
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
     *
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
     *
     * @return {@link CustomerList searchlist}
     *
     * @throws IllegalArgumentException <ul><li>wenn FirstName null
     *                                  ist</li><li>wenn FirstName leer ist</li><ul>
     */
    public CustomerList getCustomerByFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("name was null");
        }
        firstName = firstName.trim().toLowerCase();
        if (firstName.isEmpty()) {
            throw new IllegalArgumentException("name is empty");
        }
        CustomerList searchList = new CustomerList();

        for (Customer c : customers) {
            if (c.getAddressGermany().getFirstName().toLowerCase().contains(firstName)) {
                searchList.add(c);
            }
        }

        return searchList;
    }

    /**
     * Durchsucht die CustomerListe anhand des LastName und gibt eine Liste der
     * Customer zurück
     *
     * @param lastName Name des Customer
     *
     * @return {@link CustomerList searchlist}
     *
     * @throws IllegalArgumentException <ul><li>wenn LastName null
     *                                  ist</li><li>wenn LastName leer ist</li><ul>
     */
    public CustomerList getCustomerByLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("lastName was null");
        }
        lastName = lastName.trim().toLowerCase();
        if (lastName.isEmpty()) {
            throw new IllegalArgumentException("lastName is empty");
        }
        CustomerList searchList = new CustomerList();

        for (Customer c : customers) {
            if (c.getAddressGermany().getLastName().toLowerCase().contains(lastName)) {
                searchList.add(c);
            }
        }

        return searchList;
    }

    /**
     *
     * @param plz
     *
     * @return
     */
    public CustomerList getCustomerByPlz(int plz) {
        CustomerList searchList = new CustomerList();

        for (Customer c : customers) {
            if (plz == c.getAddressGermany().getPlz()) {
                searchList.add(c);
            }
        }

        return searchList;
    }

    /**
     * Durchsucht die CustomerListe anhand der Stadt und gibt eine Liste der
     * Customer zurück
     *
     * @param city Stadt des Customer
     *
     * @return {@link CustomerList searchlist}
     *
     * @throws IllegalArgumentException <ul><li>wenn Stadt null ist</li><li>wenn
     *                                  Stadt leer ist</li><ul>
     */
    public CustomerList getCustomerByCity(String city) {
        if (city == null) {
            throw new IllegalArgumentException("city was null");
        }
        city = city.trim().toLowerCase();
        if (city.isEmpty()) {
            throw new IllegalArgumentException("city is empty");
        }
        CustomerList searchList = new CustomerList();

        for (Customer c : customers) {
            if (c.getAddressGermany().getCity().toLowerCase().contains(city)) {
                searchList.add(c);
            }
        }

        return searchList;
    }

    /**
     * Durchsucht die CustomerListe anhand der Straße und gibt eine Liste der
     * Customer zurück
     *
     * @param street Straße Customer
     *
     * @return {@link CustomerList searchlist}
     *
     * @throws IllegalArgumentException <ul><li>wenn Straße null
     *                                  ist</li><li>wenn Straße leer ist</li><ul>
     */
    public CustomerList getCustomerByStreet(String street) {
        if (street == null) {
            throw new IllegalArgumentException("street was null");
        }
        street = street.trim().toLowerCase();
        if (street.isEmpty()) {
            throw new IllegalArgumentException("street is empty");
        }
        CustomerList searchList = new CustomerList();

        for (Customer c : customers) {
            if (c.getAddressGermany().getStreet().toLowerCase().contains(street)) {
                searchList.add(c);
            }
        }

        return searchList;
    }

    /**
     * @return ArrayList<Customer>
     */
    public List<Customer> toList() {
        return new ArrayList<>(customers);
    }
}
