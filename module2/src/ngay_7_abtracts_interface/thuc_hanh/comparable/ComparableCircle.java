package ngay_7_abtracts_interface.thuc_hanh.comparable;

import ngay_6_ke_thua.thuc_hanh.Circle;

// ke thua class circle o thuc hanh 6

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(String color, boolean filled, double radius) {
        super(color, filled, radius);
    }

    @Override
    public int compareTo(ComparableCircle x) {
        if (getRadius() > x.getRadius()) {
            return 1;
        } else if (getRadius() < x.getRadius()) {
            return -1;
        } else {
            return 0;
        }
    }
}
