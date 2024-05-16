package alexdev.routes;

public class AirRouteAlreadyExistsException extends RuntimeException{
    public AirRouteAlreadyExistsException(String message) {
        super(message);
    }
}
