package ngay_13_sap_xep.thuc_hanh;

public class BubbleSort {
    public static void bubbleSortWay(int[] list) {
        boolean check = true;
        for (int i = 1; i < list.length && check; i++) { // xet tu phan tu index=1
            check = false;
            for (int k = 0; k < list.length - i; k++) { // xet tu phan tu index = 0
                if (list[k] > list[k+1]) {              // neu phan tu thu index =0 lon hon phan tu sau no thi doi cho
                    int temp = list[k]; // gan bien tam de giu lai element vi tri thu k de swap vi tri k va k+1 vs nhau
                    list[k] = list[k+1];
                    list[k+1] = temp;
                    check = true;
                }
            }
            if (check == false) {
                System.out.println("Array have been already sorted before");
                break;
            }
        }
    }

    public static void main(String[] args) {
        int list1[] = {8, 32, 21, 9, 2, 27, 10};
        System.out.println("Pre - list: ");
        for (int list:list1) {
            System.out.print(list + " ");
        }
        System.out.println();
        bubbleSortWay(list1);
        System.out.println("After - list: ");
        for (int list : list1) {
            System.out.print(list + " ");
        }
    }
}
