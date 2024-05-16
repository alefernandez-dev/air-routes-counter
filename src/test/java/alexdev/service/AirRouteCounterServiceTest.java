package alexdev.service;

import alexdev.routes.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AirRouteCounterServiceTest {

    AirRoute airRoute;
    DefaultAirRouteService service;

    @BeforeEach
    void setUp() {
        airRoute = AirRoute.create(RouteCode.C_D);
        service = new DefaultAirRouteService(new InMemoryAirRouteRepository());

    }

    @Test
    void saveNewAirRoute() {
        Assertions.assertTrue(service.create(airRoute));
        Assertions.assertFalse(service.create(airRoute));
    }

    @Test
    void findAirRouteByAirCode() {
        service.create(airRoute);
        var result = Assertions.assertDoesNotThrow(() -> service.getByRouteCode(RouteCode.C_D));
        System.out.println(result);
        Assertions.assertThrowsExactly(AirRouteNotFoundException.class, () -> service.getByRouteCode(RouteCode.A_D));
    }

    void countAirRoute() {

    }

}