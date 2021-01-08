package ngay_6_ke_thua.bai_tap.CircleCylinder;

import ngay_6_ke_thua.bai_tap.CircleCylinder.Circle1;
import ngay_6_ke_thua.bai_tap.CircleCylinder.Cylinder;

public class TestCircleCylinder {
    public static void main(String[] args) {
        Circle1 circle1 = new Circle1(6, "green");
        System.out.println(circle1);
        System.out.println("From information of Circle we have Cylinder below: ");
        Cylinder cylinder = new Cylinder(6, "yellow", 15);
        System.out.println(cylinder);
    }
}
