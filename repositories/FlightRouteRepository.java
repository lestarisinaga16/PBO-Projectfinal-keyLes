package repositories;

import entities.FlightRoute;

public interface FlightRouteRepository {
    FlightRoute[] getAllRoutes();
    void addRoute(FlightRoute route);
    Boolean editRoute(FlightRoute route);
    Boolean removeRoute(int routeId);
}
