package ngay_6_ke_thua.bai_tap.CircleCylinder;

import ngay_6_ke_thua.bai_tap.CircleCylinder.Circle1;

public class Cylinder extends Circle1 {
    private double height;

    public Cylinder(double r1, String color, double height) {
        super(r1, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public void setR1(double r1) { // khong co cung khong sao
        setRadius(r1);
    }
    public double getR1() {        // khong co cung khong sao
        return getRadius();
    }

    @Override                      // khong cos cung khong sao
    public void setRadius(double radius) {
        setR1(radius);
    }

    public double getVolume() {
        return Math.floor(height * Math.PI * Math.pow(this.radius, 2) *1000) / 1000;
    }

    @Override
    public String toString() {
        return "A Cylinder with height = "
                + getHeight()
                + " and "
                + super.toString()
                + " finally there are volume = "
                + getVolume();
    }
}
