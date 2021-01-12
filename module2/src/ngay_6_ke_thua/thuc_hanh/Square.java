package ngay_6_ke_thua.thuc_hanh;

public class Square extends Rectangle {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(String color, boolean filled, double side) {
        super(color, filled, side, side);
    }

    public double getSide() {
        return getWidth();
    }
    public void setSide(double side) {
        super.setHeight(side);
        super.setWidth(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setHeight(double height) {
        setSide(height);
    }

    @Override
    public String toString() {
        return "A square with side = "
                + getSide()
                + ", which is a subclass of "
                +" Area: "
                + getArea();


    }

    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);
        square = new Square(5);
        System.out.println(square);
        square = new Square("yellow", false, 7);
        System.out.println(square);
    }
}
