package ngay_12_thuat_toan.bai_tap;

public class BinarySearchByDQ {
    public int binarySearching(int[] arr, int low, int high, int x) {
        int mid = (low + high) / 2;
        if (low > high) {
            return -1;
        } else {
            if (arr[mid] == x) {
                return mid;
            } else if (x < arr[mid]) {
                return binarySearching(arr, low, mid - 1, x);
            } else {
                return binarySearching(arr, mid + 1, high, x);
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchByDQ ob = new BinarySearchByDQ();
        int arr[] = {1, 3, 6, 7, 12, 16, 31, 38, 25};
        int x = 16;
        int size = arr.length;
        int result = ob.binarySearching(arr, 0, size - 1, x);
        if (result == -1) {
            System.out.println("Can not find anything Bro!");
        } else {
            System.out.println(x + " is found in the array in index " + result);
        }
    }
}
