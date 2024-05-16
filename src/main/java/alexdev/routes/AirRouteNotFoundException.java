package alexdev.routes;

public class AirRouteNotFoundException extends RuntimeException{
    public AirRouteNotFoundException(String message) {
        super(message);
    }
}
