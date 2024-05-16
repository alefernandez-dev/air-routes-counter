package alexdev.service;

import alexdev.routes.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultAirRouteServiceTest {

    AirRoute airRoute;
    DefaultAirRouteService service;

    @BeforeEach
    void setUp() {
        airRoute = AirRoute.create(RouteCode.C_D);
        service = new DefaultAirRouteService(new InMemoryAirRouteRepository());

    }

    @Test
    void saveNewAirRoute() {
        assertTrue(service.create(airRoute));
        assertFalse(service.create(airRoute));
    }

    @Test
    void findAirRouteByAirCode() {
        service.create(airRoute);
        var result = Assertions.assertDoesNotThrow(() -> service.getByRouteCode(RouteCode.C_D));
        System.out.println(result);
        assertThrowsExactly(AirRouteNotFoundException.class, () -> service.getByRouteCode(RouteCode.A_D));
    }

    @Test
    void countAirRoute() {
        service.create(airRoute);
        var result01 = service.getByRouteCode(airRoute.getCode());

        assertEquals(0, result01.getCounter());
        assertNull(result01.getLastView());

        service.counter(airRoute.getCode());
        var result02 = service.getByRouteCode(airRoute.getCode());

        assertEquals(1, result02.getCounter());
        assertNotNull(result02.getLastView());

    }

}