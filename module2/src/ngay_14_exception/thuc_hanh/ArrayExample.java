package ngay_14_exception.thuc_hanh;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    public Integer[] createRandom() {
        Random random = new Random();
        Integer[] array = new Integer[100];
        System.out.println("Array list: ");
        for (int i = 0; i < 100; i++) {
            array[i] = random.nextInt(100);
            System.out.print(array[i] + " ");
        }
        System.out.println();
        return array;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayExample arrayExample = new ArrayExample();
        Integer[] array = arrayExample.createRandom();
        System.out.print("Enter index that need to find: ");
        int x = scanner.nextInt();
        try {
            System.out.println("Value of element at " + x + " is " + array[x]);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Over length of array");
        }
    }
}
