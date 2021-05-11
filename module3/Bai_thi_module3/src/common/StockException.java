package common;

public class StockException extends Exception {
    public StockException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Syntax Error: " + super.getMessage();
    }

}
