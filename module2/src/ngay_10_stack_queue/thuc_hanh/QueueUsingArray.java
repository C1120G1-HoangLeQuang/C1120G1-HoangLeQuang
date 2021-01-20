package ngay_10_stack_queue.thuc_hanh;

import java.util.Arrays;

public class QueueUsingArray {
    private int capacity;  // suc chua toi da
    private int queueArr[];
    private int head = 0;
    private int tail = -1;
    private int currentSize = 0;

    public QueueUsingArray(int queueSize) {  // kich co cua mang queueArr
        this.capacity = queueSize;           // set kich co cua mang = full capacity
        queueArr = new int[this.capacity];
    }
    public boolean isQueueFull() {   // kiem tra co day hay khong?
        boolean check = false;
        if (currentSize == capacity) {
            check = true;
        }
        return check;
    }
    public boolean isQueueEmpty() {  // kiem tra co rong khong?
        boolean check = false;
        if (currentSize == 0) {
            check = true;
        }
        return check;
    }
    public void enqueue(int item) {
        if (isQueueFull()) {
            System.out.println("Can not add anymore!");
        } else {
            tail++;
            if (tail == capacity) {
                tail = 0;
            }
            queueArr[tail] = item;
            currentSize++;
            System.out.println("Element " + item + " Add into array");
        }
    }
    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Nothing to dequeue");
        } else {
            head++;
            if (head == capacity) {
                System.out.println("Already move " + queueArr[head - 1]);
                head = 0;
            } else {
                System.out.println("Already move " + queueArr[head - 1]);
            }
            currentSize--;
        }
    }

    @Override
    public String toString() {
        return "QueueUsingArray{" +
                "capacity=" + capacity +
                ", queueArr=" + Arrays.toString(queueArr) +
                ", head=" + head +
                ", tail=" + tail +
                ", currentSize=" + currentSize +
                '}';
    }

    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray(4);
        queue.enqueue(4);
        queue.dequeue();
        queue.enqueue(56);
        queue.enqueue(2);
        queue.enqueue(67);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(24);
        queue.dequeue();
        queue.enqueue(98);
        queue.enqueue(45);
        queue.enqueue(23);
        queue.enqueue(435);
        System.out.println(queue.toString());
    }
}
