package alexdev.routes;

public interface CounterAirRoute {
    boolean counter(RouteCode routeCode) throws AirRouteNotFoundException;
}
