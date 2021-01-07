package ngay_5_access_modifier.bai_tap;

public class Circle {
    private static double radius = 1.0;
    private String color = "red";

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    protected double getRadius() {
        return radius;
    }

    protected void setRadius(double radius) {
        this.radius = radius;
    }

    protected double getArea() {
        return Math.floor((Math.pow(getRadius(), 2) * Math.PI)*10000)/10000;
    }
}
