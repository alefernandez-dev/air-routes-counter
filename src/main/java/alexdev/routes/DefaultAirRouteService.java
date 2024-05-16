package alexdev.routes;

public class DefaultAirRouteService implements CreateNewAirRoute, CounterAirRoute, GetAirRouteByRouteCode {

    private final AirRoutes airRouteRepository;

    public DefaultAirRouteService(AirRoutes airRouteRepository) {
        this.airRouteRepository = airRouteRepository;
    }

    @Override
    public boolean counter(RouteCode routeCode) {

        var airRoute = airRouteRepository
                .findAirRouteByRouteCode(routeCode)
                .orElseThrow(() -> new AirRouteNotFoundException("air route '"+ routeCode +"' not found"));

        airRoute.count();
        airRoute.addLastView();

        return airRouteRepository.save(airRoute);
    }

    @Override
    public AirRoute getByRouteCode(RouteCode routeCode) {
        return airRouteRepository
                .findAirRouteByRouteCode(routeCode)
                .orElseThrow(() -> new AirRouteNotFoundException("air route '"+ routeCode +"' not found"));
    }

    @Override
    public boolean create(AirRoute airRoute) {
        return airRouteRepository.save(airRoute);
    }
}
