package Exception.CustomerException;

public class DOBException extends Exception{
    public DOBException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Syntax Error: " + super.getMessage();
    }
}
