package ngay_12_tim_kiem.thuc_hanh;

import java.util.Scanner;

public class BinarySearching {
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
    static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid])
                high = mid - 1;
            else if (key == list[mid])
                return mid;
            else
                low = mid + 1;
        }
        return -1; /* Now high < low, key not found */
    }
    public static void main(String[] args) {
        System.out.println(binarySearch(list, 2));  /* 0 */
        System.out.println(binarySearch(list, 11)); /* 4 */
        System.out.println(binarySearch(list, 79)); /*12 */
        System.out.println(binarySearch(list, 1));  /*-1 */
        System.out.println(binarySearch(list, 5));  /*-1 */
        System.out.println(binarySearch(list, 80)); /*-1 */
    }
}
//public class Practise {                             CACH II
//    static int binarySearching(int[] array, int x) {
//        int low = 0;
//        int high = array.length - 1;
//        for (int i = 0; i < array.length; i++) {
//            int mid = (high + low) / 2;
//            if (x == array[mid]) {
//                return mid;
//            } if (x < array[mid]) {
//                high = mid - 1;
//            } else {
//                low = mid + 1;
//            }
//        }
//        return -1;
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int array[] = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
//        System.out.println("Pre - array: ");
//        for (int list : array) {
//            System.out.print(list + " ");
//        }
//        System.out.println();
//        System.out.print("Enter x: ");
//        int x = scanner.nextInt();
//        System.out.println(binarySearching(array, x));
//    }
//}

