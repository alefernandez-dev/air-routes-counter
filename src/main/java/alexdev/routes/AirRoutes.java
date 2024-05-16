package alexdev.routes;

import java.util.Optional;

public interface AirRoutes {
    Optional<AirRoute> findAirRouteByRouteCode(RouteCode routeCode);
    boolean existsByRouteCode(RouteCode routeCode);
    void save(AirRoute airRoute);
}
