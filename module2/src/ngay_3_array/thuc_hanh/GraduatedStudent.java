package ngay_3_array.thuc_hanh;

import java.util.Scanner;

public class GraduatedStudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        int[] pointStudent;
        do {
            System.out.print("Enter size: ");
            size = scanner.nextInt();
            if (size > 30) {
                System.out.print("Size is over limit. Enter again");
            }
        }while (size > 30);
        pointStudent = new int[size];
        int i;
        for (i = 0; i < pointStudent.length; i++) {
            System.out.print("Enter point of student " + (i+1) + " : ");
            pointStudent[i] = scanner.nextInt();
        }
        int count1 = 0;
        System.out.print("Point of student is: ");
        for (i = 0; i < pointStudent.length; i++) {
            System.out.print(pointStudent[i] + " ");
            if (pointStudent[i] > 5 && pointStudent[i] <= 10) {
                count1++;
            }
        }
        System.out.println();
        System.out.print("Number of student is graduated is: " + count1);
    }
}
