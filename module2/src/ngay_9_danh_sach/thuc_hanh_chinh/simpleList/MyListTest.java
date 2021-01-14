package ngay_9_danh_sach.thuc_hanh_chinh.simpleList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> integerMyList = new MyList<Integer>();
        integerMyList.add(1);
        integerMyList.add(2);
        integerMyList.add(3);
        integerMyList.add(4);
        integerMyList.add(8);
        System.out.println("Element 1: " + integerMyList.get(1));
        System.out.println("Element 4: " + integerMyList.get(4));
        System.out.println("Element 3: " + integerMyList.get(3));
        integerMyList.add(-1);  // sure keo la loi
        System.out.println("Element -1: " + integerMyList.get(-1));
    }
}
