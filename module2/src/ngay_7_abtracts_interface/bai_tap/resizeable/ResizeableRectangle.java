package ngay_7_abtracts_interface.bai_tap.resizeable;

import ngay_6_ke_thua.thuc_hanh.Rectangle;

public class ResizeableRectangle extends Rectangle implements Resizeable {
    public ResizeableRectangle() {
    }

    public ResizeableRectangle(double width, double height) {
        super(width, height);
    }

    @Override
    public void resize(double percent) {
        setHeight(getHeight() + (percent/100 * getHeight()));
        setWidth(getWidth() + (percent/100 * getWidth()));
        System.out.println("Width : "+this.getWidth());
        System.out.println("Height : "+this.getHeight());
        System.out.println("Area : " + this.getArea());
    }
}
// hoac cong thuc: this.setWidth(this.getWidth() * (1+ percent/100));
//        this.setHeight(this.getHeight() * (1+ percent/100));
