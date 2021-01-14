package ngay_9_danh_sach.bai_tap.LinkedList;

public class LinkedList<E> {
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }
        public Object getData() {
            return this.data;
        }
    }
    private Node head;  // node dau tien cua linked list(phan tu dau tien)
    private int numNode = 0; // mo ta so luong Node co trong linkedlist

    public LinkedList() {
    }
    public void addFirst(E element) { // them phan tu vao dau danh sach
        Node temp = head;             // khai bao bien temp de tro? den gia tri cua head
        head = new Node(element);     // Bien head se nhan gia tri cua Node moi
        head.next = temp;             // head.next tro den temp
        numNode++;
    }
    public void addLast(E element) { //Them phan tu vao vi tri cuoi cung trong danh sach
        Node temp = head;             // Khai bao temp de tro? den head
        // Cho con tro? chay den phan tu cuoi cung trong danh sach
        while (temp.next != null) {   // neu gap null thi vong chay se dung lai
             temp = temp.next;
        }
        temp.next = new Node(element);
        numNode++;
    }
    public void add(int index, E element) {
        Node temp = head;             // Khai bao temp de tro? den head
        Node holder;                  // Khai bao bien holder
        for (int i = 0; i < index - 1 && temp.next != null; i++) {  // Cho con tro? chay den index - 1
            temp = temp.next;
        }
        holder = temp.next;            // cho holder tham chieu den vi tri index
        temp.next = new Node(element); // Node tai vi tri index - 1 se tro toi Node moi
        temp.next.next = holder;                // Node moi se tro den holder
        numNode++;
    }
    public Object get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }
    public int size1() {
        return numNode;
    }
    public E remove(int index) {  // xoa phan tu khoi mang voi index truyen vao
        if (index < 0 || index > numNode) {
            throw new IllegalArgumentException("Error Index" + index);
        }
        Node temp = head;
        Object data;
        if (index == 0) { // index = 0 thi tra ve data hien tai
            data = temp.data;
            head = head.next; // phan tu phia sau se bi day? len phia dau mang
            numNode--;
        } else {
            for (int i = 0; i < index - 1 && temp.next != null ; i++) {
                temp = temp.next;
            }
            data = temp.next.data;
            temp.next = temp.next.next;
            numNode--;
        }
        return (E) data;
    }
    public boolean remove(E element) {
        if (head.data.equals(element)) {    //Remove doi tuong neu element la head
            remove(0);
            return true;
        } else {
            Node temp = head;
            while (temp.next != null) {
                 if (temp.data.equals(element)) { // Neu nhu ton tai 1 phan tu = data truyen vao thi se Node do se remove
                     temp.next = temp.next.next;
                     numNode--;
                     return true;
                 }
                 temp = temp.next;
            }
        }
        return false;
    }
    public LinkedList<E> clone() {
       if (numNode == 0) {    // Kiem tra Linkedlist co phan tu hay khong?
          throw new NullPointerException("this Linkedlist s null");
       }
       //Khai bao Linkedlist tra ve neu > 0
        LinkedList<E> returnLinkedList = new LinkedList<>();
       Node temp = head;
       // add temp vao danh sach tra ve de no lam head
        returnLinkedList.addFirst((E) temp.data);
        temp = temp.next;
        while (temp != null) {
            returnLinkedList.addLast((E) temp.data);
            temp = temp.next;
        }
        return returnLinkedList;
    }
    public boolean contain(E element) { // kiem tra phan tu co trong danh sach khong
        Node temp = head;
        while (temp.next != null) {
            if (temp.data.equals(element)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public int indexOf(E element) { // tim phan tu o vi tri vao trong mang
        Node temp = head;
        for (int i = 0; i < numNode; i++) {
            if (temp.data.equals(element)) {
                return i;
            }
        }
        return -1;
    }
}
