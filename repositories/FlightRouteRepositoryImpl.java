package repositories;

import entities.FlightRoute;

public class FlightRouteRepositoryImpl implements FlightRouteRepository {
    private FlightRoute[] routes = new FlightRoute[10];  // Adjust size as needed

    @Override
    public FlightRoute[] getAllRoutes() {
        return routes;
    }

    @Override
    public void addRoute(FlightRoute route) {
        // Add route logic (resize array if necessary)
    }

    @Override
    public Boolean editRoute(FlightRoute route) {
        // Edit route logic
        return true;
    }

    @Override
    public Boolean removeRoute(int routeId) {
        // Remove route logic
        return true;
    }
}
