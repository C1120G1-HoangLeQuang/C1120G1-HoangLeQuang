package common;

public class CustomerException extends Exception{

    public CustomerException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Syntax Error: " + super.getMessage();
    }
}
