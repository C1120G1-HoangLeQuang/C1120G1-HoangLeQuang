package ngay_3_array.thuc_hanh;

import java.util.Scanner;

public class MinArrayByFunction {
    public static int MinArray(int[] array) {
        int min = array[0];
        int index = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array [i];
                index = i +1;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        int[] array;
        do {
            System.out.print("Enter size: ");
            size = scanner.nextInt();
            if (size > 15) {
                System.out.print("Size is over 15. Please enter again: ");
            }
        } while (size > 15);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element " + (i + 1) + " : " + " ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.print("Check list: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
        System.out.println();
        System.out.print("Min in the check list is: " + MinArray(array));
    }
}
