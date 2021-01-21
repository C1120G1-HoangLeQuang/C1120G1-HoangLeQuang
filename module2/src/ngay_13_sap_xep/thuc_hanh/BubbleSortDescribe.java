package ngay_13_sap_xep.thuc_hanh;

import java.util.Scanner;

public class BubbleSortDescribe {
    public static void bubbleSortWay(int[] list) {
        boolean check = true;
        for (int k = 1; k < list.length && check; k++) {
            check = false;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    System.out.println("Swap " + list[i] + " with " + list[i+1]);
                    int temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                    check = true;
                }
            }
            if (check == false) {
                System.out.println("Array have been already sorted before");
                break;
            }
            System.out.println("After list: ");
            for (int j = 0; j < list.length; j++) {
                System.out.print(list[j] + " ");
            }
            System.out.println();
        }
   }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter list size:");
//        int size = scanner.nextInt();
//        int[] list = new int[size];
//        System.out.println("Enter " + list.length + " values:");
//        for (int i = 0; i < list.length; i++) {
//            list[i] = scanner.nextInt();
//        }
//        System.out.print("Your input list: ");
//        for (int i = 0; i < list.length; i++) {
//            System.out.print(list[i] + "\t");
//        }
        int list1[] = {8, 32, 21, 9, 2, 27, 10};
        int list2[] = {1, 2, 3, 4, 5, 6, 7};
        bubbleSortWay(list1);
        System.out.println("Final list: ");
        for (int list:list1) {
            System.out.print(list + " ");
        }
    }
}
