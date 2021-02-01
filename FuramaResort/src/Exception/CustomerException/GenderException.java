package Exception.CustomerException;

public class GenderException extends Exception {
    public GenderException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Syntax Error: " + super.getMessage();
    }
}
