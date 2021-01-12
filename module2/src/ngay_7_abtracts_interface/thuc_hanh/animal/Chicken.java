package ngay_7_abtracts_interface.thuc_hanh.animal;

import ngay_7_abtracts_interface.thuc_hanh.interface_edibal.Edibal;

public class Chicken extends Animal implements Edibal {
    @Override
    public String makeSound() {
        return "Chicken: cuc ta cuc tac!";
    }

    @Override
    public String howToEat() {
        return "Fried to eat";
    }
}
