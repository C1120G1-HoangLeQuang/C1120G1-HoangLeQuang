package ngay_13_sap_xep.bai_tap;

public class InsertSortDescribe {
    public static void insertSortWay(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int currentElement = list[i];
            int k;
            for (k = i -1; k >= 0 && list[k] > currentElement; k--) {
                list[k+1] = list[k];
                System.out.println("Change element" + list[k] + " from " + k + " to " + (k+1));
            }
            list[k+1] = currentElement; // thuc hien gan phan tu o vi tri k+1
            System.out.println("After - list: ");
            for (int j = 0; j < list.length; j++) {
                System.out.print(list[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int list1[] = {8, 32, 21, 9, 2, 27, 10};
        System.out.println("Pre - list: ");
        for (int list:list1) {
            System.out.print(list + " ");
        }
        System.out.println();
        insertSortWay(list1);
        System.out.println("Final - list: ");
        for (int list : list1) {
            System.out.print(list + " ");
        }
    }
}
