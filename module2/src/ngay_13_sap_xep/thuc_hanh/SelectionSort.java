package ngay_13_sap_xep.thuc_hanh;

public class SelectionSort {
    public static void selectionSortWay(int[] list) {
        for (int i = 0; i < list.length -1; i++) {  // xet tu vi tri index = 0, khong xet phan tu cuoi
            int currentMin = list[i];               // gan bien tam Min vao vi tri dau tien
            int currentMinIndex = i;                // xac dinh luon vi tri ma phan tu Min dang dang dung
            for (int k = i + 1; k < list.length; k++ ) {  // xet phan tu o vi tri index ke tiep
                if (currentMin > list[k]) {               // neu vi tri dau lon hon phan tu ngay tiep theo thi swap
                    currentMin = list[k];                 // gan gia tri Min o vi tri index ke tip
                    currentMinIndex = k;                  // gan luon vi tri ma phan tu Min dang o
                }
            }
            if (currentMin != i) {                         // sau khi da xac dinh co Min moi, thuc hien swap
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
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
        selectionSortWay(list1);
        System.out.println("After - list: ");
        for (int list : list1) {
            System.out.print(list + " ");
        }
    }
}
