package alexdev.routes;

public interface CreateNewAirRoute {
    void create(AirRoute airRoute) throws AirRouteAlreadyExistsException;
}
