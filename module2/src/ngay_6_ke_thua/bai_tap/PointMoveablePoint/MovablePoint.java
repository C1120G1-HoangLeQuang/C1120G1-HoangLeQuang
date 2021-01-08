package ngay_6_ke_thua.bai_tap.PointMoveablePoint;

import ngay_6_ke_thua.bai_tap.Point2D3D.Point2D;

public class MovablePoint extends Point2D {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint() {
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] speed = new float[2];
        return speed;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "speed = (" +
                "xSpeed=" + xSpeed +
                ", ySpeed=" + ySpeed +
                "), (" +
                "x=" + x +
                ", y=" + y +
                ")" +
                '}';
    }
    public MovablePoint move() {
        this.x += xSpeed;
        this.y += ySpeed;
        return this;
    }
}
