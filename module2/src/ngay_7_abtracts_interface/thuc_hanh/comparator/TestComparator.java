package ngay_7_abtracts_interface.thuc_hanh.comparator;

import ngay_6_ke_thua.thuc_hanh.Circle;

import java.util.Arrays;

public class TestComparator {
    public static void main(String[] args) {
        Circle[] circle = new Circle[3];
        circle[0] = new Circle(3.6);
        circle[1] = new Circle();
        circle[2] = new Circle("indigo", false, 3.5);

        System.out.println("Pre-sorted: ");
        for (Circle circle1: circle) {
            System.out.println(circle1);
        }
        ComparatorCircle circleComparator = new ComparatorCircle();
        Arrays.sort(circle, circleComparator);

        System.out.println("After-sorted: ");
        for (Circle circle1: circle) {
            System.out.println(circle1);
        }
    }
}
