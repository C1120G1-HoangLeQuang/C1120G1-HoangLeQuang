package ngay_14_exception.bai_tap;

public class SideTriangleException extends Exception{
    public SideTriangleException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Fail about number of side: " + super.getMessage();
    }
}
