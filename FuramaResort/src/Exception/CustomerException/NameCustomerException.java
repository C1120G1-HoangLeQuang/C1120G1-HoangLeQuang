package Exception.CustomerException;

public class NameCustomerException extends Exception {
     public NameCustomerException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Syntax Error: " + super.getMessage();
    }
}
