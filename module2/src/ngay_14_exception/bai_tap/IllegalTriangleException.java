package ngay_14_exception.bai_tap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IllegalTriangleException {
    private static int[] enterSide() throws SideTriangleException {
        Scanner scanner = new Scanner(System.in);
        int side1, side2, side3;
        try {
            System.out.print("Enter side1: ");
            side1 = scanner.nextInt();
            System.out.print("Enter side2: ");
            side2 = scanner.nextInt();
            System.out.print("Enter side3: ");
            side3 = scanner.nextInt();
            if (side1 < 0 || side2 < 0 || side3 < 0) {
                throw new SideTriangleException("Sides is smaller 0");
            }
            if (side1 + side2 < side3 || side1 + side3 < side2 || side2 + side3 < side1) {
                throw new SideTriangleException("total of 2 sides is smaller the rest");
            }
        } catch (InputMismatchException e) {
            throw new SideTriangleException("Side have to be a number");
        }
        return new int[] {side1, side2, side3};
    }

    public static void main(String[] args) {
       try {
           int[] array = enterSide();
           System.out.println("Length of three side (side1, side2, side3) is: ");
           for (int side: array) {
               System.out.print(side + " ");
           }
       } catch (SideTriangleException e) {
           System.out.println(e.getMessage());
       }
    }
}
