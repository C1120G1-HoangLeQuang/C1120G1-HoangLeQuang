package ngay_4_OOP.bai_tap.AdamEva;

import java.util.Scanner;

public class Human extends Apple {
    private String name;
    private boolean gender;
    private int weight1;
    private String say;

    public Human() {
    }

    public Human(int weight, String name, boolean gender, int weight1, String say) {
        super(weight);
        this.name = name;
        this.gender = gender;
        this.weight1 = weight1;
        this.say = say;
    }

    protected boolean isMale() {
        return this.gender = true;
    }

    protected void setGender(boolean gender) {
        this.gender = gender;
    }
    protected boolean checkApple() {
        return isEmpty();
    }
    protected void eat(int weight, String name) {
        decrease(weight);
        this.weight1++;
        System.out.println("Weight of " + name + " after eating apple is: " + this.weight1);
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

    public int getWeight1() {
        return weight1;
    }

    public void setWeight1(int weight) {
        this.weight1 = weight;
    }

    @Override
    public String toString() {
        return  ", gender= "
                + isMale()
                + ", say="
                + say("'Delicious'")
                +'}';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Apple apple = new Apple(8);
        System.out.println(apple);
        Human human1 = new Human();
        System.out.print("Enter weight of human: ");
        human1.setWeight1(scanner.nextInt());
        System.out.print("Enter name: ");
        human1.setName(scanner.next());
        System.out.println("Human{Name: " + human1.getName() + ", weight: " + human1.getWeight1() + human1);
        human1.eat(apple.weight, human1.getName());
        apple.decrease(apple.getWeight());
        System.out.println("The rest of apple's weight is: " + apple.getWeight());
    }
}
