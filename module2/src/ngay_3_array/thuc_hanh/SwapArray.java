package ngay_3_array.thuc_hanh;

import java.util.Scanner;

public class SwapArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        int [] array;
        do {
            System.out.print("Enter size: ");
            size = scanner.nextInt();
            if (size > 20) {
                System.out.println("Size does not exceed 20");
            }
        } while (size > 20);
        array = new int[size];
        int i =0;
        while (i < array.length) {
            System.out.print("Enter element " + (i+1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.println("Element in array: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] +" ");
        }
        for (int j = 0; j < array.length /2; j++) {
            int temp = array [j];
            array [j] = array[size - 1 - j];
            array [size - 1 - j] = temp;
        }
        System.out.printf("Reverse array: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
    }
}
