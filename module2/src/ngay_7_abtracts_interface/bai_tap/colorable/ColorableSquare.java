package ngay_7_abtracts_interface.bai_tap.colorable;

import ngay_6_ke_thua.thuc_hanh.Square;
import ngay_7_abtracts_interface.bai_tap.resizeable.ResizeableSquare;

public class ColorableSquare extends Square implements Colorable {
    public ColorableSquare(double side) {
        super(side);
    }



    @Override
    public void howToColor() {
        System.out.println("Color all four sides..");
    }
}
