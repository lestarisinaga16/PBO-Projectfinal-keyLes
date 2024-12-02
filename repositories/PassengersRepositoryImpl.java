package repositories;

import entities.Passengers;

public class PassengersRepositoryImpl implements PassengersRepository {
    public static Passengers[] passengers = new Passengers[2]; // Initial array size

    @Override
    public Passengers[] getAll() {
        return passengers;
    }

    @Override
    public void add(final Passengers passenger) {
        resizeArrayIfFull(); // Check and resize array if needed
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] == null) {
                passengers[i] = passenger;
                break;
            }
        }
    }

    private void resizeArrayIfFull() {
        if (isArrayFull()) {
            resizeArrayToTwoTimesBigger();
        }
    }

    private boolean isArrayFull() {
        for (Passengers passenger : passengers) {
            if (passenger == null) {
                return false;
            }
        }
        return true;
    }

    private void resizeArrayToTwoTimesBigger() {
        Passengers[] temp = passengers;
        passengers = new Passengers[temp.length * 2];
        for (int i = 0; i < temp.length; i++) {
            passengers[i] = temp[i];
        }
    }

    @Override
    public Boolean remove(final Integer id) {
        if (isSelectedPassengerNotValid(id)) {
            return false;
        }
        for (int i = id - 1; i < passengers.length - 1; i++) {
            passengers[i] = passengers[i + 1];
        }
        passengers[passengers.length - 1] = null;
        return true;
    }

    private boolean isSelectedPassengerNotValid(final Integer id) {
        return id <= 0 || id > passengers.length || passengers[id - 1] == null;
    }

    @Override
    public Boolean edit(final Passengers passenger) {
        if (isSelectedPassengerNotValid(passenger.getId())) {
            return false;
        }
        passengers[passenger.getId() - 1] = passenger;
        return true;
    }
}
