package PassengerApp.services;

import PassengerApp.entities.Passengers;

public interface PassengersService {
    Passengers[] getPassengerList();
    void addPassenger(Passengers passenger);
    Boolean removePassenger(Integer id);
    Boolean editPassenger(Integer id, Passengers updatedPassenger);
}