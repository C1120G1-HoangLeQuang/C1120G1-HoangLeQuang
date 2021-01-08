package ngay_6_ke_thua.bai_tap.Point2D3D;

import ngay_6_ke_thua.bai_tap.Point2D3D.Point2D;
import ngay_6_ke_thua.bai_tap.Point2D3D.Point3D;

public class Test2D3D {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(4, 8);
        System.out.println(point2D);
        Point3D point3D = new Point3D(3);
        point3D.setXY(point2D.getX(), point2D.getY());
        System.out.println(point3D);
    }
}
