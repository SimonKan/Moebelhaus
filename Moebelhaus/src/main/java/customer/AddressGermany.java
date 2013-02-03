package customer;

/**
 * Abstrakte Klasse mit sechs Attributen, nach denen die Objekte von einander
 * abgegrenzt werden.
 *
 * @author Simon
 */
public abstract class AddressGermany {

    private String firstName;
    private String lastName;
    private String city;
    private int plz;
    private String street;
    private String houseNumber;
    /*
     * Konstruktor zur Erstellung der einzelnen Objekte anhand der Attribute
     */

    public AddressGermany(String firstName, String lastName, String city, int plz, String street, String houseNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.plz = plz;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    /*
     * Get Methoden zum Aufruf der einzelnen Werte der verschiedenen Attribute
     */
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getCity() {
        return this.city;
    }

    public int getPlz() {
        return this.plz;
    }

    public String getStreet() {
        return this.street;
    }

    public String getHouseNumber() {
        return this.houseNumber;
    }

    public String toString() {
        throw new UnsupportedOperationException();
    }
}