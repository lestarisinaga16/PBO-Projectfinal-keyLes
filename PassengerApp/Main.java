package PassengerApp;

import PassengerApp.repositories.PassengersRepository;
import PassengerApp.repositories.PassengersRepositoryImpl;
import PassengerApp.services.PassengersService;
import PassengerApp.services.PassengerServiceImpl;
import PassengerApp.views.PassengerTerminalViewImpl;
import PassengerApp.views.PassengersView;

public class Main {
    public static void main(String[] args) {
        PassengersRepository passengerRepository = new PassengersRepositoryImpl();
        PassengersService passengerService = new PassengerServiceImpl(passengerRepository);
        PassengersView passengerView = new PassengerTerminalViewImpl(passengerService);

        passengerView.run();
    }
}
