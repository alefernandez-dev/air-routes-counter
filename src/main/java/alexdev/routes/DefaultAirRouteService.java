package alexdev.routes;

public class DefaultAirRouteService implements CreateNewAirRoute, CounterAirRoute, GetAirRouteByRouteCode {

    private final AirRoutes airRouteRepository;

    public DefaultAirRouteService(AirRoutes airRouteRepository) {
        this.airRouteRepository = airRouteRepository;
    }

    @Override
    public void counter(RouteCode routeCode) throws AirRouteNotFoundException{

        var airRoute = airRouteRepository
                .findAirRouteByRouteCode(routeCode)
                .orElseThrow(() -> new AirRouteNotFoundException("air route '"+ routeCode +"' not found"));

        airRoute.count();
        airRoute.addLastView();

        airRouteRepository.save(airRoute);
    }

    @Override
    public AirRoute getByRouteCode(RouteCode routeCode) throws AirRouteNotFoundException{
        return airRouteRepository
                .findAirRouteByRouteCode(routeCode)
                .orElseThrow(() -> new AirRouteNotFoundException("air route '"+ routeCode +"' not found"));
    }

    @Override
    public void create(AirRoute airRoute) throws AirRouteAlreadyExistsException{

        if (airRouteRepository.existsByRouteCode(airRoute.getCode())) {
            throw new AirRouteAlreadyExistsException("route code '"+ airRoute.getCode() +"' already exists");
        }

        airRouteRepository.save(airRoute);
    }
}
