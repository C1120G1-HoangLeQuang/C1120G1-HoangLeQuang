package Model;

import Library.ForeignManager;

public class ForeignCustomer extends Customer{
    private String nationality;

    public ForeignCustomer() {
    }

    public ForeignCustomer(String idCustomer, String nameCustomer, String nationality) {
        super(idCustomer, nameCustomer);
        this.nationality = nationality;
    }
    public ForeignCustomer(String[] customerInfor) {
        super(customerInfor[0], customerInfor[1]);
        this.nationality = customerInfor[2];
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    float calculator() {
        return 0;
    }

    @Override
    public String toString() {
        return  idCustomer + "," +
                nameCustomer + "," +
                nationality;
    }
    public String showInformation() {
        return "ForeignCustomer{" +
                "IdCustomer='" + getIdCustomer() + "," +
                "NameCustomer='" + getNameCustomer() + "," +
                "Nationality='" + getNationality() + "}";
    }
}
