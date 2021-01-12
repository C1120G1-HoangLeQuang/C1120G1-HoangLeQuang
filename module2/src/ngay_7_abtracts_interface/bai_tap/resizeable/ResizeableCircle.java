package ngay_7_abtracts_interface.bai_tap.resizeable;

import ngay_6_ke_thua.thuc_hanh.Circle;

public class ResizeableCircle extends Circle implements Resizeable {

    public ResizeableCircle(double radius) {
        super(radius);
    }

    @Override
    public void resize(double percent) {
        setRadius(getRadius() + (percent/100 * getRadius()));
        System.out.println("Radius : "+this.getRadius());
        System.out.println("Area : "+this.getArea());
    }
}
// hoac cong thuc: this.setRadius(this.getRadius() * (1 + percent/100));