package services;

import entities.Passengers;

public interface PassengersService {
    // Mengambil daftar penumpang
    Passengers[] getPassengerList();

    // Menambahkan penumpang
    void addPassenger(Passengers passenger);

    // Menghapus penumpang berdasarkan ID
    Boolean removePassenger(Integer id);

    // Mengedit data penumpang berdasarkan ID
    Boolean editPassenger(Integer id, Passengers updatedPassenger);

}
