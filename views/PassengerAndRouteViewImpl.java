package views;

import entities.Passengers;
import entities.FlightRoute;
import services.PassengersService;
import services.FlightRouteService;

import java.util.List;
import java.util.Scanner;

public class PassengerAndRouteViewImpl implements PassengerAndRouteView {
    private final PassengersService passengersService;
    private final FlightRouteService routeService;
    private final Scanner scanner;

    public PassengerAndRouteViewImpl(PassengersService passengersService, FlightRouteService routeService) {
        this.passengersService = passengersService;
        this.routeService = routeService;
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void run() {
        boolean exit = false;
        while (!exit) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addPassenger();
                    break;
                case 2:
                    showPassengerList(passengersService.getPassengerList());
                    break;
                case 3:
                    showRouteList(routeService.getAllFlightRoutes());
                    break;
                case 4:
                    addRoute();
                    break;
                case 5:
                    editRoute();
                    break;
                case 6:
                    removeRoute();
                    break;
                case 7:
                    editPassenger();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }

    @Override
    public void displayPassengerMenu() {
        System.out.println("1. Add Passenger");
        System.out.println("2. Show Passenger List");
        System.out.println("3. Show Route List");
        System.out.println("4. Add Route");
        System.out.println("5. Edit Route");
        System.out.println("6. Remove Route");
        System.out.println("7. Edit Passenger");
        System.out.println("8. Exit");
        System.out.print("Choose an option: ");
    }

    @Override
    public void displayRouteMenu() {

    }

    @Override
    public void displayMainMenu() {
        System.out.println("1. Add Passenger");
        System.out.println("2. Show Passenger List");
        System.out.println("3. Show Route List");
        System.out.println("4. Add Route");
        System.out.println("5. Edit Route");
        System.out.println("6. Remove Route");
        System.out.println("7. Edit Passenger");
        System.out.println("8. Exit");
        System.out.print("Choose an option: ");
    }

    @Override
    public void addPassenger() {
        System.out.println("Enter passenger details:");
        // Capture passenger details and call add method
        System.out.println("Enter passenger name:");
        String name = scanner.nextLine();
        System.out.println("Enter passenger age:");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.println("Enter passport number:");
        String passportNumber = scanner.nextLine();

        Passengers passenger = new Passengers();
        passenger.setName(name);
        passenger.setAge(age);
        passenger.setPassportNumber(passportNumber);

        passengersService.addPassenger(passenger); // Call service to add passenger
        System.out.println("Passenger added successfully!");
    }

    @Override
    public void editPassenger() {
        System.out.println("Enter passenger ID to edit:");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Retrieve the passenger list
        Passengers[] passengersList = passengersService.getPassengerList();
        Passengers passengerToEdit = null;

        // Find the passenger with the matching ID
        for (Passengers passenger : passengersList) {
            if (passenger.getId() == id) {  // Pastikan ada metode getId() di kelas Passengers
                passengerToEdit = passenger;
                break;
            }
        }

        if (passengerToEdit != null) {
            System.out.println("Enter new name (leave blank to keep current):");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                passengerToEdit.setName(newName);
            }
            // Ulangi proses ini untuk atribut lainnya...

            passengersService.editPassenger(id, passengerToEdit);  // Kirim objek individual
            System.out.println("Passenger edited successfully!");
        } else {
            System.out.println("Passenger not found!");
        }
    }


    @Override
    public void removePassenger() {
        System.out.println("Enter passenger ID to remove:");
        // Call remove method from service
        System.out.println("Enter passenger ID to remove:");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        boolean removed = passengersService.removePassenger(id);

        if (removed) {
            System.out.println("Passenger removed successfully!");
        } else {
            System.out.println("Passenger not found or could not be removed.");
        }
    }

    @Override
    public void showPassengerList(Passengers[] passengers) {
        if (passengers == null || passengers.length == 0) {
            System.out.println("No passengers found.");
        } else {
            for (Passengers passenger : passengers) {
                System.out.println(passenger.getName() + " | " + passenger.getAge());
            }
        }
    }

    @Override
    public void addRoute() {
        System.out.println("Enter departure city:");
        String departureCity = scanner.nextLine();
        System.out.println("Enter arrival city:");
        String arrivalCity = scanner.nextLine();
        System.out.println("Enter departure time:");
        String departureTime = scanner.nextLine();
        System.out.println("Enter arrival time:");
        String arrivalTime = scanner.nextLine();

        FlightRoute route = new FlightRoute();
        route.setDepartureCity(departureCity);
        route.setArrivalCity(arrivalCity);
        route.setDepartureTime(departureTime);
        route.setArrivalTime(arrivalTime);

        routeService.addFlightRoute(route); // Call service to add route
        System.out.println("Route added successfully!");


    }

    @Override
    public void editRoute() {
        System.out.println("Enter route ID to edit:");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Retrieve all routes
        FlightRoute[] routes = routeService.getAllFlightRoutes();
        FlightRoute routeToEdit = null;

        // Find the route with the matching ID
        for (FlightRoute route : routes) {
            if (route.getId() == id) {
                routeToEdit = route;
                break;
            }
        }

        if (routeToEdit != null) {
            // Now you can update the route
            System.out.println("Enter new departure city (leave blank to keep current):");
            String newDepartureCity = scanner.nextLine();
            if (!newDepartureCity.isEmpty()) {
                routeToEdit.setDepartureCity(newDepartureCity);
            }

            // Repeat for other fields...

            routeService.editFlightRoute(routeToEdit);  // Call service to edit route
            System.out.println("Route edited successfully!");
        } else {
            System.out.println("Route not found!");
        }
    }


    @Override
    public void removeRoute() {
        System.out.println("Enter route ID to remove:");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        boolean removed = routeService.removeFlightRoute(id);

        if (removed) {
            System.out.println("Route removed successfully!");
        } else {
            System.out.println("Route not found or could not be removed.");
        }
    }

    @Override
    public void showRouteList(FlightRoute[] routes) {

    }

    @Override
    public void showRouteList() {
        System.out.println("DAFTAR RUTE PENERBANGAN");
        List<FlightRoute> routeList = List.of(routeService.getAllFlightRoutes()); // Pastikan Anda mendapatkan daftar rute
        for (int i = 0; i < routeList.size(); i++) {
            FlightRoute route = routeList.get(i);
            System.out.println((i + 1) + ". ID: " + route.getId() + ", Departure City: " + route.getDepartureCity() +
                    ", Arrival City: " + route.getArrivalCity() + ", Departure Time: " + route.getDepartureTime() +
                    ", Arrival Time: " + route.getArrivalTime());
        }
    }


}
