package ngay_6_ke_thua.bai_tap.CircleCylinder;

public class Circle1 {
    protected double radius = 2.0;
    private String color = "yellow";

    public Circle1() {
    }

    public Circle1(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea() {
        return Math.floor((radius * radius * Math.PI) *1000)/1000;
    }

    @Override
    public String toString() {
        return "A circle have radius is = "
                + getRadius()
                + " and color is: "
                + getColor();
    }
}
