package ngay_10_stack_queue.thuc_hanh;

public class StackUsingArray {
    private int arr[];
    private int size;
    private int index = 0;

    public StackUsingArray(int size) {
        this.size = size;
        arr = new int[size];
    }
    public int size() {
        return index;
    }
    public boolean isFull() {
        if (index == size) {
            return true;
        }
        return false;
    }
    public boolean isEmpty() {
        if (index == 0) {
            return true;
        }
        return false;
    }
    public void push(int element){
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        arr[index] = element;
        index++;
    }
    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is null");
        }
        return arr[--index];
    }
    public static void main(String[] as) throws Exception {
        StackUsingArray stack = new StackUsingArray(5);

        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        System.out.println("1. Size of stack after push operations: " + stack.size());
        System.out.printf("2. Pop elements from stack : ");

        while (!stack.isEmpty()) {
            System.out.printf(" %d", stack.pop());
        }

        System.out.println("\n3. Size of stack after pop operations : " + stack.size());
    }
}

