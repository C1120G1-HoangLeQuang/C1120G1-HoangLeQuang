package Model;

public class Brand {
    private String idBrand;
    private String nameBrand;
    private String nationBrand;

    public Brand() {
    }

    public Brand(String idBrand, String nameBrand, String nationBrand) {
        this.idBrand = idBrand;
        this.nameBrand = nameBrand;
        this.nationBrand = nationBrand;
    }

    public String getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(String idBrand) {
        this.idBrand = idBrand;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public String getNationBrand() {
        return nationBrand;
    }

    public void setNationBrand(String nationBrand) {
        this.nationBrand = nationBrand;
    }

    @Override
    public String toString() {
        return  idBrand + "," +
                nameBrand + "," +
                nationBrand;
    }
    public String showInformation() {
        return "Brand {" + "Id: " + getIdBrand() + ", "
                         + "Name: " + getNameBrand() + ", "
                         + "Nation: " + getNationBrand();
    }
}
