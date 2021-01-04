package ngay_2_vong_lap.thuc_hanh;

import java.util.Scanner;

public class TienLaiChoVay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money, month, rate;
        System.out.println("Enter money: ");
        money = scanner.nextDouble();
        System.out.println("Enter number of month: ");
        month = scanner.nextDouble();
        System.out.println("Enter annual interest rate in percentage: ");
        rate = scanner.nextDouble();
        double total_interest = 0;
        for (int i = 0; i < month; i++) {
            total_interest += money * ((rate/100)/12) * month;
        }
        System.out.println("Total of interest: " + total_interest);
    }
}
