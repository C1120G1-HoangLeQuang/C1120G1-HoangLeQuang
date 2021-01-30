package Models;

public class Customer {
    private String nameCustomer;
    private String dateOfBirth;
    private String gender;
    private int idCustomer;
    private int telephoneNumber;
    private String email;
    private String typeCustomer;
    private String address;
    private Services usingService;

    public Customer() {
    }

    public Customer(String nameCustomer, String dateOfBirth, String gender, int idCustomer, int telephoneNumber, String email, String typeCustomer, String address) {
        this.nameCustomer = nameCustomer;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCustomer = idCustomer;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer
    ) {
        this.idCustomer = idCustomer;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getUsingService() {
        return usingService;
    }

    public void setUsingService(Services usingService) {
        this.usingService = usingService;
    }

    public String showInformation() {
        return "Customer {" + "Name: " + getNameCustomer() + "\n"
                    + "Date of Birth: " + getDateOfBirth() + "\n"
                    + "Gender: " + getGender() + "\n"
                    + "Id Number: " + getIdCustomer() + "\n"
                    + "Telephone Number: " + getTelephoneNumber() + "\n"
                    + "Email: " + getEmail() + "\n"
                    + "Type of Customer: " + getTypeCustomer() + "\n"
                    + "Address: " + getAddress() + "\n"
                    + "Service: " + getUsingService();
    }

    @Override
    public String toString() {
        return  nameCustomer + ',' +
                dateOfBirth + ',' +
                gender + ',' +
                idCustomer + ',' +
                telephoneNumber + ',' +
                email + ',' +
                typeCustomer + ',' +
                address + ',' +
                usingService;
    }
}
