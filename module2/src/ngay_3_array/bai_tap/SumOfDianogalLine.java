package ngay_3_array.bai_tap;

import java.util.Scanner;

public class SumOfDianogalLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size1;
        int size2;
        int[][] matrix;
        do {
            System.out.print("Enter size1: ");
            size1 = scanner.nextInt();
            System.out.print("Enter size2: ");
            size2 = scanner.nextInt();
            if (size1>20 && size2 > 20) {
                System.out.print("Size is over limited. Enter again");
            }
        } while (size1>20 && size2 > 20);
        matrix = new int[size1][size2];
        int i;
        int j;
        for (i = 0; i < size1; i++) {
            for (j = 0; j < size2; j++) {
                System.out.print("Matrix[" + i + "][" + j + "] = ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Matrix: ");
        for (i = 0; i < size1; i++) {
            for (j = 0; j < size2; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        int sum1 = 0;
        int sum2 = 0;
        for (i = 0; i < matrix.length; i++) {
            sum1 += matrix[i][i];
        }
        for (i = 0; i < matrix.length; i++) {
            sum2 += matrix[i][matrix[i].length -1 -i];
        }
        System.out.println("Sum of the first diagonal line: " + sum1 + " and the second is:  " + sum2);
    }
}
