package ngay_6_ke_thua.bai_tap.Triangle;

import ngay_6_ke_thua.thuc_hanh.Shape;

import java.util.Scanner;

public class Triangle extends Shape {
    double side1 = 1.0;
    double side2 = 1.0;
    double side3 = 1.0;
    double height = 1.0;

    public Triangle() {
    }

    public Triangle(String color, boolean filled, double side1, double side2, double side3, double height) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.height = height;
    }

    public Triangle(String color, boolean filled) {
        super(color, filled);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    public double getArea() {
        return (this.side1 + this.height) / 2;
    }

    @Override
    public String toString() {
        return "A Triangle with side1 = "
                + getSide1()
                + " side 2 = "
                + getSide2()
                + " side3 = "
                + getSide3()
                + " height = "
                + getHeight()
                + " have perimeter = "
                + getPerimeter()
                + " and area = "
                + getArea()
                + ", which is a subclass of "
                + super.toString();
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle("Yellow", false);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter side1: ");
        triangle.setSide1(scanner.nextDouble());
        System.out.print("Enter side2: ");
        triangle.setSide2(scanner.nextDouble());
        System.out.print("Enter side3: ");
        triangle.setSide3(scanner.nextDouble());
        System.out.print("Enter height: ");
        triangle.setHeight(scanner.nextDouble());
        System.out.println(triangle.toString());
    }
}
