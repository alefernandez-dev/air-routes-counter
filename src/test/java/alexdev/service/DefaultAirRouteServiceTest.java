package alexdev.service;

import alexdev.routes.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultAirRouteServiceTest {

    @Mock
    AirRoutes repositoryMock;

    @InjectMocks
    DefaultAirRouteService service;

    AirRoute airRoute;

    @BeforeEach
    void setUp() {
        airRoute = AirRoute.create(RouteCode.C_D);
    }

    @Test
    void saveNewAirRouteSuccessfully() {

        when(repositoryMock.existsByRouteCode(airRoute.getCode())).thenReturn(false);
        assertDoesNotThrow(() -> service.create(airRoute));
    }

    @Test
    void saveRepeatedAirRoute() {

        when(repositoryMock.existsByRouteCode(airRoute.getCode())).thenReturn(true);
        var e = assertThrowsExactly(AirRouteAlreadyExistsException.class, () -> service.create(airRoute));
        System.out.println("exception message = " + e.getMessage());
    }

    @Test
    void findAirRouteByAirCode() {
        when(repositoryMock.findAirRouteByRouteCode(airRoute.getCode())).thenReturn(Optional.of(airRoute));
        var result = Assertions.assertDoesNotThrow(() -> service.getByRouteCode(airRoute.getCode()));
        System.out.println("air route = " + result);
    }

    @Test
    void findAirRouteByAirCodeWhenAirRouteDoesNotExists() {
        when(repositoryMock.findAirRouteByRouteCode(airRoute.getCode())).thenReturn(Optional.empty());
        var e = assertThrowsExactly(AirRouteNotFoundException.class, () -> service.getByRouteCode(airRoute.getCode()));
        System.out.println("exception message = " + e.getMessage());
    }

    @Test
    void countAirRoute() {

        when(repositoryMock.findAirRouteByRouteCode(airRoute.getCode())).thenReturn(Optional.of(airRoute));

        assertDoesNotThrow(() -> service.counter(airRoute.getCode()));
        assertEquals(1, airRoute.getCounter());
        assertNotNull(airRoute.getLastView());
        System.out.println(airRoute);
    }

    @Test
    void countAirRouteWhenAirRouteDoesNotExists() {

        when(repositoryMock.findAirRouteByRouteCode(airRoute.getCode())).thenReturn(Optional.empty());

        var e = assertThrowsExactly(AirRouteNotFoundException.class, () -> service.counter(airRoute.getCode()));
        System.out.println("exception message = " + e.getMessage());

    }

}