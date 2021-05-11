package Model;

public class TypeCustomer {
    private String idType;
    private String nameType;

    public TypeCustomer() {
    }

    public TypeCustomer(String idType, String nameType) {
        this.idType = idType;
        this.nameType = nameType;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    @Override
    public String toString() {
        return idType + "," +
               nameType + "}";
    }
    public String showInformation() {
        return "TypeCustomer {" + "Id: " + getIdType() + ","
                                + "Name: " + getNameType() + "}";
    }
}
