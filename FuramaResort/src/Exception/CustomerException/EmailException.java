package Exception.CustomerException;

public class EmailException extends Exception {
    public EmailException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Syntax Error: " + super.getMessage();
    }
}
