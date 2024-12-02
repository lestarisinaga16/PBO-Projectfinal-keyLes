import repositories.PassengersRepository;
import repositories.PassengersRepositoryImpl;
import services.PassengersService;
import services.PassengerServiceImpl;
import views.PassengerTerminalViewImpl;
import views.PassengersView;

public class Main {
    public static void main(String[] args) {
        PassengersRepository passengerRepository = new PassengersRepositoryImpl();
        PassengersService passengerService = new PassengerServiceImpl(passengerRepository);
        PassengersView passengerView = new PassengerTerminalViewImpl(passengerService);

        passengerView.run();
    }
}
