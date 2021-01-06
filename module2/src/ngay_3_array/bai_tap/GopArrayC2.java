package ngay_3_array.bai_tap;

import java.util.Scanner;

public class GopArrayC2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[5];
        int[] b = new int[6];
        int[] ab = new int[a.length + b.length];
        int i, j, k, l = 0;
        System.out.println("Enter a: ");
        for (i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
            for (k = i; k < ab.length; k++) {
                ab[k] = a[i];
            }
        }
        System.out.println("Enter b: ");
        for (j = 0; j < b.length; j++) {
            b[j] = scanner.nextInt();
            for (k = a.length + j; k < ab.length; k++) {
                ab[k] = b[j];
            }
        }
        System.out.println();
        System.out.println("ab is: ");
        for (l = 0; l < ab.length; l++) {
            System.out.print(ab[l] + " ");
        }
    }
}
