package ngay_7_abtracts_interface.bai_tap.resizeable;

import ngay_6_ke_thua.thuc_hanh.Shape;

import java.util.Arrays;

import static java.util.Arrays.*;

public class TestResizeable {
    public static void main(String[] args) {
        Shape[] shape = new Shape[3];
        shape[0] = new ResizeableCircle(4);
        shape[1] = new ResizeableRectangle(5,6);
        shape[2] = new ResizeableSquare(7);
        System.out.println("Pre - size: ");
        for (Shape shape1: shape) {
            System.out.println(shape1);
            Resizeable resizeableShape;
            if (shape1 instanceof ResizeableCircle){
                resizeableShape = (ResizeableCircle) shape1;
            } else if (shape1 instanceof ResizeableRectangle) {
                resizeableShape = (ResizeableRectangle) shape1;
            } else {
                resizeableShape = (ResizeableSquare) shape1;
            }
            double percent = 1 + Math.round(99 * Math.random());
            resizeableShape.resize(percent);
            System.out.println("After - size: " + resizeableShape + " with increase " + percent + "%");
        }
    }
}
