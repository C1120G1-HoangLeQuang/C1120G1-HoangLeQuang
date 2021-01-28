package session_17_String_Regax.bai_tap.TelephoneNumber;

import java.util.Scanner;

public class TestTelephone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter telephone number: ");
        String inputNumber = scanner.nextLine();
        CheckTelephoneNumber checkTelephone = new CheckTelephoneNumber();
        System.out.println(checkTelephone.validate(inputNumber));
    }
}
