package alexdev.routes;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryAirRouteRepository implements AirRoutes {

    private final Map<RouteCode, AirRoute> airRouteMap = new HashMap<>();

    @Override
    public Optional<AirRoute> findAirRouteByRouteCode(RouteCode routeCode) {
        return Optional.ofNullable(airRouteMap.get(routeCode));
    }

    @Override
    public boolean existsByRouteCode(RouteCode routeCode) {
        return airRouteMap.containsKey(routeCode);
    }

    @Override
    public void save(AirRoute airRoute) {
        airRouteMap.put(airRoute.getCode(), airRoute);
    }
}
