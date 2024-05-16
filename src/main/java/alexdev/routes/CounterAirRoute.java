package alexdev.routes;

public interface CounterAirRoute {
    void counter(RouteCode routeCode) throws AirRouteNotFoundException;
}
