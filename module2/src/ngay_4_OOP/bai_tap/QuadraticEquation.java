package ngay_4_OOP.bai_tap;

import java.util.Scanner;

public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
    public double getDiscriminant() {
        return Math.pow(this.b, 2) - (4 * this.a * this.c);
    }
    public double getRoot1() {
        return (-this.b + Math.sqrt(getDiscriminant()) / (this.a * 2));
    }
    public double getRoot2() {
        return (-this.b - Math.sqrt(getDiscriminant()) / (this.a * 2));
    }
    public String display() {
        return "a = " + this.a + " b = " + this.b + " c = " + this.c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter c: ");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        double delta = quadraticEquation.getDiscriminant();
        System.out.println("Display a, b, c: " + quadraticEquation.display());
        if (delta >= 0) {
            System.out.print("r1= " + quadraticEquation.getRoot1() + " and "+ " r2= " + quadraticEquation.getRoot2());
        } else if (delta == 0) {
            System.out.print("Only one r= " + quadraticEquation.getRoot1());
        } else {
            System.out.println("The equation has no roots");
        }
    }
}
