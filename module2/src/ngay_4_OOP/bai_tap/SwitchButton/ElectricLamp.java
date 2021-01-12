package ngay_4_OOP.bai_tap.SwitchButton;

public class ElectricLamp {
    protected boolean status1;

    public ElectricLamp() {
    }
    public void turnOn(boolean status1) {
        this.status1 = true;
        System.out.println("Lamp is on");
    }
    public void turnOff(boolean status1) {
        this.status1 = false;
        System.out.println("Lamp is off");
    }
}
