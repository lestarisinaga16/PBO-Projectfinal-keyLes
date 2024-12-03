package repositories;

import entities.Passengers;

public class PassengersRepositoryDbImpl implements PassengersRepository{
    @Override
    public Passengers[] getAll() {
        return new Passengers[0];
    }

    @Override
    public void add(Passengers passengers) {

    }

    @Override
    public Boolean remove(Integer id) {
        return null;
    }

    @Override
    public Boolean edit(Passengers passengers) {
        return null;
    }
}
