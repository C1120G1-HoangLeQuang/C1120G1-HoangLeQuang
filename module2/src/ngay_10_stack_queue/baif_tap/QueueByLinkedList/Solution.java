package ngay_10_stack_queue.baif_tap.QueueByLinkedList;

public class Solution {
    protected static void enQueue(Queue queue, int value) { // tao queue danh sach vong
        Node temp = new Node();
        temp.data = value;
        if (queue.front == null) {
            queue.front = temp;
        } else {
            queue.rear.link = temp;
        }
        queue.rear = temp;
        queue.rear.link = queue.front;
    }
    protected static int deQueue(Queue queue) {    // lay ra phan tu danh sach vong, luon lay ra o vi tri front
        if (queue.front == null) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int value;
        if (queue.front == queue.rear) { // neu trong queue chi co duy nhat 1 phan tu
            value = queue.front.data;
            queue.front = null;
            queue.rear = null;
        } else {                          // co nhieu hon 1 phan tu
            Node temp = queue.front;
            value = temp.data;
            queue.front = queue.front.link;
            queue.rear.link = queue.front;
        }
        return value;
    }
    protected static void displayQueue(Queue queue) {
        Node temp = queue.front;
        System.out.println("Elements in Circular Queue is: ");
        while (temp.link != queue.front) {
            System.out.println(temp.data);
            temp = temp.link;
        }
        System.out.println(temp.data);
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.front = queue.rear = null;   // Create a queue and initialize front and rear
        enQueue(queue, 20);         // Them phan tu vao queue
        enQueue(queue, 8);
        enQueue(queue,93);
        displayQueue(queue);              // Hien thi
        // xoa phan tu ra khoi queue
        System.out.println("Delete value: " + deQueue(queue));
        // phan tu con lai trong queue
        displayQueue(queue);
        enQueue(queue, 21);
        enQueue(queue, 7);
        displayQueue(queue);
    }

}
