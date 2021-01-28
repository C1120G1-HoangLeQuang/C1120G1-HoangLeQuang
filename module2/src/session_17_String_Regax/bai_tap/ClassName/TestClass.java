package session_17_String_Regax.bai_tap.ClassName;

import session_17_String_Regax.bai_tap.ClassName.CheckClass;

import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter class name: ");
        String inputName = scanner.nextLine();
        CheckClass checkClass = new CheckClass();
        System.out.println(checkClass.validate(inputName));
    }
}
