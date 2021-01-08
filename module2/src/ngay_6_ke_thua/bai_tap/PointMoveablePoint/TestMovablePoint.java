package ngay_6_ke_thua.bai_tap.PointMoveablePoint;

import ngay_6_ke_thua.bai_tap.Point2D3D.Point2D;

public class TestMovablePoint {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(2, 7);
        System.out.println(point2D);
        MovablePoint movablePoint = new MovablePoint(6, 9);
        movablePoint.setXY(point2D.getX(), point2D.getY());
        System.out.println(movablePoint);
        System.out.println(movablePoint.move());
    }
}
