package Model;

public abstract class Transportation {
    public String licensePlate;
    public String brand;
    public String yearMFG;
    public String owner;

    public Transportation() {
    }

    public Transportation(String licensePlate, String brand, String yearMFG, String owner) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.yearMFG = yearMFG;
        this.owner = owner;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYearMFG() {
        return yearMFG;
    }

    public void setYearMFG(String yearMFG) {
        this.yearMFG = yearMFG;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    abstract String showInformation();
}
