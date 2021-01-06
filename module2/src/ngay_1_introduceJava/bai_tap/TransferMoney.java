package ngay_1_introduceJava.bai_tap;

import java.util.Scanner;

public class TransferMoney {
    public static void main(String[] args) {
        double vnd;
        double usd;
        double result;
        Scanner scanner = new Scanner(System.in);
        String demand;
        System.out.println("What would you like to transfer from (USD to VND) or from (VND to USD)? ");
        demand = scanner.nextLine();
        switch (demand) {
            case "USD to VND" :
                System.out.println("Enter USD: ");
                usd = scanner.nextDouble();
                result = usd * 23000;
                System.out.println("Value of VND: " + result);
                break;
            case "VND to USD" :
                System.out.println("Enter VND: ");
                vnd = scanner.nextDouble();
                result = vnd / 23000;
                System.out.println("Value of USD: " + result);
                break;
        }
    }
}
