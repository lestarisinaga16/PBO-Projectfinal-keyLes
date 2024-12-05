package views;

import entities.Passengers;
import entities.FlightRoute;

public interface PassengerAndRouteView {
    void run();
    void displayPassengerMenu();
    void displayRouteMenu();
    void displayMainMenu();
    void addPassenger();
    void editPassenger();
    void removePassenger();
    void showPassengerList(Passengers[] passengers);
    void addRoute();
    void editRoute();
    void removeRoute();
    void showRouteList(FlightRoute[] routes);
}

