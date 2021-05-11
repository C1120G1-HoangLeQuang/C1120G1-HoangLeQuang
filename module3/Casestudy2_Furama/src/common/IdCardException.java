package common;

public class IdCardException extends Exception {
    public IdCardException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Syntax Error: " + super.getMessage();
    }
}
