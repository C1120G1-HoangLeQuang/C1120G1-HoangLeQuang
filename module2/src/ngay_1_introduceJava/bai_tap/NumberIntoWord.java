package ngay_1_introduceJava.bai_tap;

import java.util.Scanner;

public class NumberIntoWord {
    public static int unit(int number1) {
        switch (number1) {
            case 0 :
                System.out.println("Zero");
                break;
            case 1 :
                System.out.println("One");
                break;
            case 2 :
                System.out.println("Two");
                break;
            case 3 :
                System.out.println("Three");
                break;
            case 4 :
                System.out.println("Four");
                break;
            case 5 :
                System.out.println("Five");
                break;
            case 6 :
                System.out.println("Six");
                break;
            case 7 :
                System.out.println("Seven");
                break;
            case 8 :
                System.out.println("Eight");
                break;
            case 9 :
                System.out.println("Nine");
                break;
            default :
                System.out.println("Out of ability");
                break;
        }
        return number1;
    }
    private static int dozen(int number) {
        switch (number) {
          //  case 0 :
          //      System.out.println("Ten");
          //      break;
            case 1 :
                System.out.println("Ten");
                break;
            case 2 :
                System.out.println("Twenty");
                break;
            case 3 :
                System.out.println("Thirty");
                break;
            case 4 :
                System.out.println("Forty");
                break;
            case 5 :
                System.out.println("Fifty");
                break;
            case 6 :
                System.out.println("Sixty");
                break;
            case 7 :
                System.out.println("Seventy");
                break;
            case 8 :
                System.out.println("Eighty");
                break;
            case 9 :
                System.out.println("Ninety");
                break;
            default :
                System.out.println("Out of ability");
                break;
        }
        return number;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println("Enter a number that need to translate into word: ");
        number = scanner.nextInt();
        int dv = number % 10;
        int c = (number / 10) % 10;
        System.out.println();
    }
}
