package services;

import entities.Passengers;
import repositories.PassengersRepository;

public class PassengerServiceImpl implements PassengersService {
    private final PassengersRepository passengerRepository;

    public PassengerServiceImpl(PassengersRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public Passengers[] getPassengerList() {
        return passengerRepository.getAll();
    }

    @Override
    public void addPassenger(final Passengers passenger) {
        if (passenger == null || passenger.getName().isBlank()) {
            System.out.println("Masukkan data penumpang dengan benar.");
            return;
        }
        passengerRepository.add(passenger);
    }

    @Override
    public Boolean removePassenger(final Integer id) {
        return passengerRepository.remove(id);
    }

    @Override
    public Boolean editPassenger(final Integer id, Passengers updatedPassenger) {
        if (updatedPassenger == null || updatedPassenger.getName().isBlank()) {
            System.out.println("Data penumpang tidak valid.");
            return false;
        }
        updatedPassenger.setId(id);
        return passengerRepository.edit(updatedPassenger);
    }
}
