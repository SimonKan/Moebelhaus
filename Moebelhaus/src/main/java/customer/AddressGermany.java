package customer;

/**
 * Klasse mit sechs Attributen, nach denen die Objekte von einander abgegrenzt
 * werden.
 *
 * @author Simon
 */
public class AddressGermany {

    /**
     * Konstruktor zur Erstellung der einzelnen Objekte anhand der Attribute
     *
     * @param firstName   der Vorname
     * @param lastName    der Nachname
     * @param city        die Stadt
     * @param plz         die Postleitzahl
     * @param street      der Straßenname
     * @param houseNumber die Hausnummer
     *
     * @return eine {@link AddressGermany Adresse}
     *
     * @throws IllegalArgumentException <ul>
     *                                  <li>wenn firstName null ist</li>
     *                                  <li>wenn firstName leer ist</li>
     *                                  <li>wenn lastName null ist</li>
     *                                  <li>wenn lastName leer ist </li>
     *                                  <li>wenn city null ist </li>
     *                                  <li>wenn city leer ist </li>
     *                                  <li>wenn plz zu groß ist </li>
     *                                  <li>wenn street null ist </li>
     *                                  <li>wenn street leer ist </li>
     *                                  <li>wenn houseNumber null ist </li>
     *                                  <li>wenn houseNumber leer ist </li>
     *                                  </ul>
     * 
     * TODO throws für argument plz überarbeiten
     */
    public static AddressGermany create(String firstName, String lastName,
                                        String city, int plz, String street,
                                        String houseNumber) {
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
        houseNumber = houseNumber.trim();
        if (houseNumber.isEmpty()) {
            throw new IllegalArgumentException("houseNumber was empty");
        }
        if (!houseNumber.matches("\\d+[a-zA-Z]")) {
            throw new IllegalArgumentException("houseNumber '" + houseNumber
                + "' invalid");
        }
        AddressGermany address = new AddressGermany();

        address.firstName = firstName;
        address.lastName = lastName;
        address.plz = plz;
        address.city = city;
        address.street = street;
        address.houseNumber = houseNumber;

        return address;

    }
    private String firstName;
    private String lastName;
    private String city;
    private int plz;
    private String street;
    private String houseNumber;

    /*
     * Der eigentlich Konstruktor wird vermieden, damit das Programm
     * die Factory Methode verwendet
     */
    private AddressGermany() {
    }
    /*
     * Get Methoden zum Aufruf der einzelnen Werte der verschiedenen Attribute
     */

    /**
     *
     * @return firstName
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     *
     * @return lastName
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     *
     * @return City
     */
    public String getCity() {
        return this.city;
    }

    /**
     *
     * @return Plz
     */
    public int getPlz() {
        return this.plz;
    }

    /**
     *
     * @return Street
     */
    public String getStreet() {
        return this.street;
    }

    /**
     *
     * @return HouseNumber
     */
    public String getHouseNumber() {
        return this.houseNumber;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }
}