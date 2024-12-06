import config.Database;
import repositories.PassengersRepository;
import repositories.PassengerRepositoryDbImpl;
import repositories.FlightRouteRepository;
import repositories.FlightRouteRepositoryImpl;
import services.PassengersService;
import services.PassengerServiceImpl;
import services.FlightRouteService;
import services.FlightRouteServiceImpl;
import views.PassengerAndRouteView;
import views.PassengerAndRouteViewImpl;

public class Main {
    public static void main(String[] args) {
        // Setup untuk Passenger
        Database database = new Database("databasekeyles", "root", "", "localhost", "3306");
        PassengersRepository passengerRepository = new PassengerRepositoryDbImpl(database);
        PassengersService passengersService = new PassengerServiceImpl(passengerRepository);

        // Setup untuk Route
        FlightRouteRepository routeRepository = new FlightRouteRepositoryImpl();
        FlightRouteService routeService = new FlightRouteServiceImpl(routeRepository);

        // Setup View
        PassengerAndRouteView passengerAndRouteView = new PassengerAndRouteViewImpl(passengersService, routeService);

        // Jalankan aplikasi
        passengerAndRouteView.run();
    }
}


