package ngay_6_ke_thua.thuc_hanh;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(5.8);
        System.out.println(circle);
        circle = new Circle("black", false, 6.9);
        System.out.println(circle);
    }
}
