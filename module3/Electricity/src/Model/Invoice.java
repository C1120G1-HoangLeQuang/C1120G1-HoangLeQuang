package Model;

public class Invoice {
    private String invoiceCode;
    private String idCustomerBill;
    private String releaseDate;
    private float consumption;
    private float unitPrice;
    private float payment;

    public Invoice() {
    }

    public Invoice(String invoiceCode, String idCustomerBill, String releaseDate, float consumption, float unitPrice, float payment) {
        this.invoiceCode = invoiceCode;
        this.idCustomerBill = idCustomerBill;
        this.releaseDate = releaseDate;
        this.consumption = consumption;
        this.unitPrice = unitPrice;
        this.payment = payment;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getIdCustomerBill() {
        return idCustomerBill;
    }

    public void setIdCustomerBill(String idCustomerBill) {
        this.idCustomerBill = idCustomerBill;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public float getConsumption() {
        return consumption;
    }

    public void setConsumption(float consumption) {
        this.consumption = consumption;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {

    }

}
