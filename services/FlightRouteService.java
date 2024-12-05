package services;

import entities.FlightRoute;

public interface FlightRouteService {
    void addFlightRoute(FlightRoute route);
    boolean removeFlightRoute(int id);
    boolean editFlightRoute(FlightRoute updatedRoute);
    FlightRoute[] getAllFlightRoutes();
}
