package ngay_5_access_modifier.thuc_hanh;

public class TestStaticPropertyCar {
    public static void main(String[] args) {
        StaticPropertyCar car1 = new StaticPropertyCar("Volwagen ", " B40 ");
        System.out.println(car1.numberOfCar);
        StaticPropertyCar car2 = new StaticPropertyCar("BMW ", " A5000 ");
        System.out.println(car2.numberOfCar);
    }
}
