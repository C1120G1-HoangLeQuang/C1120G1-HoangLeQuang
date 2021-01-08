package ngay_4_OOP.bai_tap;

public class Apple {
    private int weight = 10;

    protected Apple(int weight) {
        this.weight = weight;
    }
    protected int getWeight() {
        return this.weight;
    }
    protected void decrease(int weight) {
        if (this.weight > 0) {
            this.weight--;
        }
    }
    protected boolean isEmpty() {
        return true;
    }
}

