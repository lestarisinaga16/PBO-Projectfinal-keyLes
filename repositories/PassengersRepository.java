package repositories;

import entities.Passengers;

public interface PassengersRepository {
    Passengers[] getAll();

    void add(Passengers passengers);

    Boolean remove(Integer id);

    Boolean edit(Passengers passengers);
}
