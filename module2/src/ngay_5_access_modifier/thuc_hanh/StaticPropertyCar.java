package ngay_5_access_modifier.thuc_hanh;

public class StaticPropertyCar {
    private String name;
    private String engine;
    public static int numberOfCar;

    public StaticPropertyCar(String name, String engine) {
        this.name = name;
        this.engine = engine;
        numberOfCar++;
    }
}
