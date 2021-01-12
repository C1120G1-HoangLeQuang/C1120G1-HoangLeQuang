package ngay_7_abtracts_interface.bai_tap.colorable;

import ngay_6_ke_thua.thuc_hanh.Circle;
import ngay_6_ke_thua.thuc_hanh.Rectangle;
import ngay_6_ke_thua.thuc_hanh.Shape;
import ngay_6_ke_thua.thuc_hanh.Square;

public class TestColorableSquare {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Square(4);
        shapes[1] = new ColorableSquare(5);
        shapes[2] = new Rectangle(6, 8);
        shapes[3] = new Circle(9);
        Colorable colorable;
        for (Shape shape1:shapes) {
            if (shape1 instanceof ColorableSquare) {
                colorable = (ColorableSquare) shape1;
                colorable.howToColor();
            }
            System.out.println(shape1);
        }
    }
}
