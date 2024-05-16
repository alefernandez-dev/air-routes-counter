package alexdev.routes;

public interface GetAirRouteByRouteCode {
    AirRoute getByRouteCode(RouteCode routeCode) throws AirRouteNotFoundException;
}
