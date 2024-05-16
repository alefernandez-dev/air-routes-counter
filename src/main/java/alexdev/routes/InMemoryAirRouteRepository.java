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
    public boolean save(AirRoute airRoute) {
        return airRouteMap.putIfAbsent(airRoute.getCode(), airRoute) == null;
    }
}
