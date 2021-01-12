package ngay_7_abtracts_interface.bai_tap.resizeable;

import ngay_6_ke_thua.thuc_hanh.Square;

public class ResizeableSquare extends Square implements Resizeable {
    public ResizeableSquare() {
    }

    public ResizeableSquare(double side) {
        super(side);
    }

    @Override
    public void resize(double percent) {
        setSide(getSide() + (percent/100 * getSide()));
        System.out.println("Side : "+this.getSide());
        System.out.println("Area : "+this.getArea());
    }
}
// hoac cog thuc: this.setSide(this.getSide()*(1+ percent/100));