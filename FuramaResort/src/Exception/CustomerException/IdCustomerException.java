package Exception.CustomerException;

public class IdCustomerException extends Exception {
    public IdCustomerException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Syntax Error: " + super.getMessage();
    }
}
