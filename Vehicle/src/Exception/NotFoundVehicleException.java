package Exception;


public class NotFoundVehicleException extends Exception {
    public  NotFoundVehicleException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "NotFoundVehicleException: " + super.getMessage();
    }
}
