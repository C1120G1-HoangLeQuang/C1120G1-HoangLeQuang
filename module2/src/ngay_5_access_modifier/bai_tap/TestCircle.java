package ngay_5_access_modifier.bai_tap;

import java.util.Scanner;

public class TestCircle extends Circle{
    public static void main(String[] args) {
        TestCircle circle = new TestCircle();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter radius: ");
        circle.setRadius(scanner.nextDouble());
        System.out.print("Area of Circle = " + circle.getArea());
    }
}
