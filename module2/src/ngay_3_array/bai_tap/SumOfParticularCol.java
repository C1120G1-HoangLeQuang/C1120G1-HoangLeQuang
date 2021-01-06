package ngay_3_array.bai_tap;

import java.util.Scanner;

public class SumOfParticularCol {
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
            if (size1 > 15 && size2 > 15) {
                System.out.println("Size is over limited. Enter again: ");
            }
        } while ((size1 > 15) && (size2 > 15));
        matrix = new int[size1][size2];
        int i;
        int j;
        for (i = 0; i < size1; i++) {
            for (j = 0; j < size2; j++) {
                System.out.print("matrix[" + i + "][" + j + "] = ");
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
        System.out.print("Which column that you want to calculated sum: ");
        int column = scanner.nextInt();
        int sum = 0;
        for (j = 0; j < matrix[0].length; j++) {
            if (j == column) {
                for (i = 0; i < matrix.length; i++) {
                    sum += matrix[i][j];
                }
                System.out.println("Sum of column " + column + " is: " + sum);
            }

        }

    }
}
