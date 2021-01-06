package ngay_3_array.bai_tap;

import java.util.Scanner;

public class MaxOfArray2Way {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[2][2];
        System.out.println("Enter matrix " + matrix.length + " row and " + matrix[0].length + " columns: ");
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = scanner.nextInt();
            }
        }
        for (int row = 0; row < matrix.length;row++) {
            System.out.println("table is: " + row);
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.println(matrix[row][column] + " ");
            }
            System.out.println();
        }
        int max = matrix[0][0];
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (matrix[row][column] > max) {
                    max = matrix[row][column];
                }
            }
            System.out.println("The max valuable in matrix is: " + max);
        }
    }
}
