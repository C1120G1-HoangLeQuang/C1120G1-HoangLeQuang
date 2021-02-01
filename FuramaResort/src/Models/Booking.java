package Models;

public class Booking {
    private int idCustomer;
    private String idService;

    public Booking() {
    }

    public Booking(int idCustomer, String idService) {
        this.idCustomer = idCustomer;
        this.idService = idService;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    @Override
    public String toString() {
        return idCustomer + "," +
                idService;
    }
    public String showInformation() {
        return "Booking {" + "Customer: " + getIdCustomer() + ", "
                        + "Service: " + getIdService() + "}";
    }
}
