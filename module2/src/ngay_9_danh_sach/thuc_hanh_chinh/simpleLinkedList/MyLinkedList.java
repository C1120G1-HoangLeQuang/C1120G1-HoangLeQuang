package ngay_9_danh_sach.thuc_hanh_chinh.simpleLinkedList;

public class MyLinkedList {
    private Node head; // buoc nay thuc hien sau khi tao class Node
    private int numNodes;

    public MyLinkedList(Object data) {
        head = new Node(data);   // buoc nay thuc hien sau khi tao class Node
    }

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }
    public void add(int index, Object data) {
        Node temp = head; // gan bien tam cho phan tu dau tien
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }
    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }
    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
