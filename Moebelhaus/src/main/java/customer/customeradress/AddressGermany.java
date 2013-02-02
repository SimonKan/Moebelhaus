package customer.customeradress;

public class AddressGermany {

    private String firstName;
    private String lastName;
    private String city;
    private int plz;
    private String street;
    private String houseNumber;

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