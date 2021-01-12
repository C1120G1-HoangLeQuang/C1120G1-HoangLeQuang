package ngay_7_abtracts_interface.thuc_hanh.comparable;

import java.util.Arrays;

public class TestComparable {
    public static void main(String[] args) {
        ComparableCircle[] circle1 = new ComparableCircle[3];
        circle1[0] = new ComparableCircle(3.6);
        circle1[1] = new ComparableCircle();
        circle1[2] = new ComparableCircle("indigo", false, 3.5);
        System.out.println("Pre - sorted: ");
        for (ComparableCircle circle: circle1) {
            System.out.println(circle);
        }
        Arrays.sort(circle1);
        System.out.println("After - sorted: ");
        for (ComparableCircle circle: circle1) {
            System.out.println(circle);
        }
    }
}
