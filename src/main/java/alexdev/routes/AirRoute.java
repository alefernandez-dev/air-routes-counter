package alexdev.routes;

import java.time.LocalDateTime;

public class AirRoute {
    private final RouteCode code;
    private Integer counter;
    private LocalDateTime lastView;

    public AirRoute(RouteCode code, Integer counter, LocalDateTime lastView) {
        this.code = code;
        this.counter = counter;
        this.lastView = lastView;
    }

    public static AirRoute create(RouteCode code) {
        return new AirRoute(code, 0, null);
    }

    public RouteCode getCode() {
        return code;
    }

    public Integer getCounter() {
        return counter;
    }

    public LocalDateTime getLastView() {
        return lastView;
    }

    public void count() {
        counter++;
    }

    public void addLastView() {
        this.lastView = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "AirRoute{" +
                "code=" + code +
                ", counter=" + counter +
                ", lastView=" + lastView +
                '}';
    }
}
