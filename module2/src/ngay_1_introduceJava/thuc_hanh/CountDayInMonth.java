package ngay_1_introduceJava.thuc_hanh;

import java.util.Scanner;

public class CountDayInMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which month that you want to count days: ");
        int month = scanner.nextInt();
        switch (month) {
            case 2 :
                System.out.println("Month: " + month + " have 28 days or 29 days ");
            break;
            case 1 :
            case 3 :
            case 5 :
            case 7 :
            case 8 :
            case 10 :
            case 12 :
                System.out.println("Month: " + month + " have 31 days");
            break;
            case 4 :
            case 6 :
            case 9 :
            case 11 :
                System.out.println("Month" + month + " have 30 days");
        }
    }
}
