package ngay_9_danh_sach.thuc_hanh_chinh.simpleLinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList linkedList = new MyLinkedList(10);
        linkedList.addFirst(11);
        linkedList.addFirst(12);
        linkedList.addFirst(13);
        linkedList.add(4, 9);
        linkedList.add(5, 8);
        linkedList.printList();
    }
}
