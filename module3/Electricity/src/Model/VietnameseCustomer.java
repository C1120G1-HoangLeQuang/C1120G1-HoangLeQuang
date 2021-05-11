package Model;

public class VietnameseCustomer extends Customer{
    private String typeCustomer;
    private int limitedUsing;

    public VietnameseCustomer() {
    }

    public VietnameseCustomer(String idCustomer, String nameCustomer, String typeCustomer, int limitedUsing) {
        super(idCustomer, nameCustomer);
        this.typeCustomer = typeCustomer;
        this.limitedUsing = limitedUsing;
    }


    public VietnameseCustomer(String[] customerInfor) {
        super(customerInfor[0], customerInfor[1]);
        this.typeCustomer = customerInfor[2];
        this.limitedUsing = Integer.parseInt(customerInfor[3]);
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public float getLimitedUsing() {
        return limitedUsing;
    }

    public void setLimitedUsing(int limitedUsing) {
        this.limitedUsing = limitedUsing;
    }

    @Override
    float calculator() {
        return 0;
    }

    @Override
    public String toString() {
        return  idCustomer + "," +
                nameCustomer + "," +
                typeCustomer + "," +
                limitedUsing;
    }
    public String showInformation() {
        return "Customer{" +
                "IdCustomer='" + getIdCustomer() + "," +
                "NameCustomer='" + getNameCustomer() + "," +
                "TypeCustomer='" + getTypeCustomer() + "," +
                "LimitedUsing=" + getLimitedUsing() + "}";
    }
}
