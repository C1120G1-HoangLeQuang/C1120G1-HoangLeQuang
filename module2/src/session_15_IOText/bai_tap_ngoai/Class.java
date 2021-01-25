package session_15_IOText.bai_tap_ngoai;

public class Class {
    private String lastName;
    private String firstName;
    private String street;
    private String district;
    private String city;
    public Class(String lastName, String firstName, String street, String district, String city) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.street = street;
        this.district = district;
        this.city = city;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getStreet() {
        return street;
    }
    public String getDistrict() {
        return district;
    }
    public String getCity() {
        return city;
    }
}
