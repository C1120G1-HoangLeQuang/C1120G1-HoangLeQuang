package ngay_3_array.bai_tap;

import java.util.Scanner;

public class InsertElement {
    public static int [] insert(int[] arr, int index, int x) {
        int[] newArray = new int[arr.length +1];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        for (int i = index; i < newArray.length-1; i++) {
            newArray[i+1] = arr[i];
        }
        newArray[index] = x;
         return newArray;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        int[] arrPrime;
        do {
            System.out.print("Enter size: ");
            size = scanner.nextInt();
            if (size > 15) {
                System.out.print("Size is over limited. Please enter again");
            }
        } while (size > 15);
        arrPrime = new int[size];
        int i = 0;
        while (i < arrPrime.length) {
            System.out.print("Array element " + (i) + " : " + " ");
            arrPrime[i] = scanner.nextInt();
            i++;
        }
        System.out.print("Prime list: ");
        for (int j = 0; j < arrPrime.length; j++) {
            System.out.print(arrPrime[j] + " ");
        }
        System.out.println();
        int index;
        System.out.print("Enter index where you want to insert new prime: " );
        index = scanner.nextInt();
        int newPrime;
        System.out.print("Enter new prime: ");
        newPrime = scanner.nextInt();
        arrPrime = insert(arrPrime, index, newPrime);
        System.out.print("New list: ");
        for (int k = 0; k < arrPrime.length; k++) {
            System.out.print(arrPrime[k] + " ");
        }
    }
}

