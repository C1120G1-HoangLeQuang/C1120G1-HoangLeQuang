package ngay_4_OOP.bai_tap.AdamEva;

public class Apple {
    protected int weight = 10;

    public Apple() {
    }

    protected Apple(int weight) {
        this.weight = weight;
    }
    protected int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    protected void decrease(int weight) {
        if (this.weight > 0) {
            this.weight--;
        }
    }
    protected boolean isEmpty() {
        return true;
    }

    @Override
    public String toString() {
        return "Apple's weight: "
                + getWeight();
    }
}

