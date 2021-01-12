package ngay_4_OOP.bai_tap.SwitchButton;

import java.util.Scanner;

public class SwitchButton extends ElectricLamp{
    private boolean status;
    private ElectricLamp lamp;


    public SwitchButton() {
    }

    public void connectToLamp(ElectricLamp lamp) { // de ket noi voi class ElectricLamp
        this.lamp = lamp;
   }
    public void sWitchOnOff(boolean status) {
        this.status = status;
        if (this.status == true ) {
            this.lamp.turnOn(true);
        } else {
            this.lamp.turnOff(false);
        }
    }

    public static void main(String[] args) {
        ElectricLamp lamp1 = new ElectricLamp();
        SwitchButton switchButton = new SwitchButton();
        Scanner scanner = new Scanner(System.in);
        switchButton.connectToLamp(lamp1);
        int count;
        System.out.print("Enter number of time On anf Off: ");
        count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            switchButton.sWitchOnOff(true);
            switchButton.sWitchOnOff(false);
        }
    }
}
