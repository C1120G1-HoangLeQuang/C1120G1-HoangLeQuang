package ngay_4_OOP.bai_tap;

import java.util.Scanner;

public class Human {
    private String name;
    private boolean gender;
    private int weight;
    private String say;


    public Human() {
    }
    protected boolean isMale() {
        return true;
    }

    protected void setGender(boolean gender) {
        this.gender = gender;
    }
    protected boolean checkApple() {
        return true;
    }
    protected void eat() {
    }
    protected String say(String say) {
        return this.say = say;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
}
