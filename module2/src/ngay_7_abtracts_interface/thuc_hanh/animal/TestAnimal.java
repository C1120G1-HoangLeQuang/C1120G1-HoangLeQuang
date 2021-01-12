package ngay_7_abtracts_interface.thuc_hanh.animal;

import ngay_7_abtracts_interface.thuc_hanh.fruit.Apple;
import ngay_7_abtracts_interface.thuc_hanh.fruit.Fruit;
import ngay_7_abtracts_interface.thuc_hanh.fruit.Orange;
import ngay_7_abtracts_interface.thuc_hanh.interface_edibal.Edibal;

public class TestAnimal {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
            if (animal instanceof Chicken) {
                Edibal edibal = (Chicken) animal;
                System.out.println(edibal.howToEat());
            }
        }
        Fruit[] fruit = new Fruit[2];
        fruit[0] = new Apple();
        fruit[1] = new Orange();
        for (Fruit fruit1: fruit) {
            System.out.println(fruit1.howToEat());
        }
    }
}
