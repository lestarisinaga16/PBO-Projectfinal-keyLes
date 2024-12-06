package services;

import entities.FlightRoute;
import repositories.FlightRouteRepository;

import java.util.ArrayList;
import java.util.List;

public class FlightRouteServiceImpl implements FlightRouteService {
    private final FlightRouteRepository routeRepository;
    private List<FlightRoute> routes = new ArrayList<>();

    public FlightRouteServiceImpl(FlightRouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }
    private List<FlightRoute> FlightRoutes = new ArrayList<>();
    public List<FlightRoute> getAllRoutes() {
        return routes;  // Kembalikan list rute penerbangan
    }

    @Override
    public void addFlightRoute(FlightRoute route) {
        routes.add(route);
    }

    @Override
    public boolean removeFlightRoute(int id) {
        for (FlightRoute route : routes) {
            if (route.getId() == id) {
                routes.remove(route);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean editFlightRoute(FlightRoute updatedRoute) {
        for (FlightRoute route : routes) {
            if (route.getId() == updatedRoute.getId()) {  // Memastikan ID rute yang ada cocok dengan ID dari updatedRoute
                route.setDepartureCity(updatedRoute.getDepartureCity());
                route.setArrivalCity(updatedRoute.getArrivalCity());
                route.setDepartureTime(updatedRoute.getDepartureTime());
                route.setArrivalTime(updatedRoute.getArrivalTime());
                return true;  // Rute berhasil diperbarui
            }
        }
        return false;  // Tidak ditemukan rute dengan ID yang sesuai
    }


    @Override
    public FlightRoute[] getAllFlightRoutes() {
        return routes.toArray(new FlightRoute[0]);
    }
}
