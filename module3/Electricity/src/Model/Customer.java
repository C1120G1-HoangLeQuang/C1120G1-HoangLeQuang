package Model;

public abstract class Customer {
    public String idCustomer;
    public String nameCustomer;

    public Customer() {
    }

    public Customer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Customer(String idCustomer, String nameCustomer) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    abstract float calculator();
}
