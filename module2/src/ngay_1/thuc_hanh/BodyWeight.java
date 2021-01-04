package ngay_1.thuc_hanh;

import java.util.Scanner;

public class BodyWeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight, height, bmi;
        System.out.println("Enter weight(in kilogram): ");
        weight = scanner.nextDouble();
        System.out.println("Enter height(in meter): ");
        height = scanner.nextDouble();
        bmi = weight/Math.pow(height,2);
        if (bmi < 18.0) {
            System.out.println("Your body weight is: " +  bmi + " You are Underweight");
        } else if (bmi < 25.0) {
            System.out.println("Your body weight is: " +  bmi + " You are Normal");
        } else if (bmi < 30.0) {
            System.out.println("Your body weight is: " +  bmi + " You are Overweight");
        } else {
            System.out.println("Your body weight is: " +  bmi + " You are Obese");
        }
    }
}
