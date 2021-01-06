package ngay_3_array.thuc_hanh;

import java.util.Scanner;

public class FindElement {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name that you want to find: ");
        String input = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(input)) {
                System.out.println("Position of the student in the list" + input + " is: "  + (i+1));
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println("Not found:" + input + " in the list.");
        }
    }


}
