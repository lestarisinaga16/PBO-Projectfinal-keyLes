package repositories;

import entities.Passengers;

public interface PassengersRepository {
    // Mengambil semua penumpang
    Passengers[] getAll();

    // Menambahkan penumpang
    void add(Passengers passenger);

    // Menghapus penumpang berdasarkan ID
    Boolean remove(Integer id);

    // Mengedit data penumpang berdasarkan ID
    Boolean edit(Passengers passenger);
}
