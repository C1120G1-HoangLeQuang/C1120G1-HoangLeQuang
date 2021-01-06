package ngay_3_array.bai_tap;

import java.util.Scanner;

public class MoveElementFromArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        int[] array;
        do {
            System.out.print("Enter size: ");
            size = scanner.nextInt();
            if (size > 15) {
                System.out.println("Size is over limited. Please enter agaain");
            }
        } while (size > 15);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Array element " + (i+1) + " : " + " ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.print("Check list: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
        System.out.println();
        System.out.print("Enter the prime that you want to delete: ");
        int delete = scanner.nextInt();
        boolean check = false;
        for (int j = 0; j < array.length; j++) {
            if (array[j] == delete) {
                System.out.println("Position of the students in the list " + delete + " is: " + (j+1));
                check = true;
                for(int k = j; k < array.length-1; k++) {
                    array[k] = array[k+1];
                }
                array[array.length-1]=0;
                System.out.println("New list: ");
                for (int k = 0; k < array.length; k++) {
                    System.out.print(array[k] + " ");
                }
                break;
            }
        }
        if (!check) {
            System.out.println("Not found " + delete + " in the list");
        }

    }
}
