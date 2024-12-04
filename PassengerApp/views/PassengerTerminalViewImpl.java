package PassengerApp.views;

import PassengerApp.entities.Passengers;
import PassengerApp.services.PassengersService;

import java.util.Scanner;

public class PassengerTerminalViewImpl implements PassengersView {
    public static Scanner scanner = new Scanner(System.in);
    private final PassengersService passengerService;


    public PassengerTerminalViewImpl(PassengersService passengerService) {
        this.passengerService = passengerService;
    }

    public String input(String info) {
        System.out.print(info + " : ");
        return scanner.nextLine();
    }

    public void showMainMenu() {
        boolean isRunning = true;
        while (isRunning) {
            showPassengerList();
            System.out.println("MENU : ");
            System.out.println("1. Tambah Penumpang");
            System.out.println("2. Hapus Penumpang");
            System.out.println("3. Edit Penumpang");
            System.out.println("4. Keluar");

            String selectedMenu = input("Pilih");

            switch (selectedMenu) {
                case "1":
                    showMenuAddPassenger();
                    break;
                case "2":
                    showMenuRemovePassenger();
                    break;
                case "3":
                    showMenuEditPassenger();
                    break;
                case "4":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilih menu dengan benar");
            }
        }
    }

    public void showMenuRemovePassenger() {
        System.out.println("MENGHAPUS DATA PENUMPANG");
        var number = input("Nomor yang dihapus (x jika batal)");
        if (!number.equalsIgnoreCase("x")) {
            boolean success = passengerService.removePassenger(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus penumpang : " + number);
            } else {
                System.out.println("Berhasil menghapus penumpang.");
            }
        }
    }

    public void showMenuAddPassenger() {
        System.out.println("MENAMBAH DATA PENUMPANG");
        String name = input("Nama Penumpang (x jika batal)");
        if (name.equalsIgnoreCase("x")) return;

        String age = input("Umur Penumpang");
        String gender = input("Jenis Kelamin (L/P)");
        String passportNumber = input("Nomor Paspor");
        String ktpNumber = input("Nomor KTP");

        Passengers passenger = new Passengers();
        passenger.setName(name);
        passenger.setAge(Integer.parseInt(age));
        passenger.setGender(gender);
        passenger.setPassportNumber(passportNumber);
        passenger.setKtpNumber(ktpNumber);

        passengerService.addPassenger(passenger);
        System.out.println("Penumpang berhasil ditambahkan.");
    }

    public void showMenuEditPassenger() {
        System.out.println("MENGEDIT DATA PENUMPANG");
        String selectedPassenger = input("Masukkan nomor penumpang (x jika batal)");
        if (selectedPassenger.equalsIgnoreCase("x")) return;

        String newName = input("Masukkan nama baru (x jika batal)");
        if (newName.equalsIgnoreCase("x")) return;

        String newAge = input("Masukkan umur baru");
        String newGender = input("Masukkan jenis kelamin baru (L/P)");
        String newPassportNumber = input("Masukkan nomor paspor baru");
        String newKtpNumber = input("Masukkan nomor KTP baru");

        Passengers updatedPassenger = new Passengers();
        updatedPassenger.setName(newName);
        updatedPassenger.setAge(Integer.parseInt(newAge));
        updatedPassenger.setGender(newGender);
        updatedPassenger.setPassportNumber(newPassportNumber);
        updatedPassenger.setKtpNumber(newKtpNumber);

        boolean isEditSuccess = passengerService.editPassenger(Integer.valueOf(selectedPassenger), updatedPassenger);
        if (isEditSuccess) {
            System.out.println("Berhasil mengedit data penumpang.");
        } else {
            System.out.println("Gagal mengedit data penumpang.");
        }
    }

    public void showPassengerList() {
        System.out.println("DAFTAR PENUMPANG");
        Passengers[] passengerList = passengerService.getPassengerList();
        for (var i = 0; i < passengerList.length; i++) {
            var passenger = passengerList[i];
            if (passenger != null) {
                System.out.println((i + 1) + ". Nama: " + passenger.getName() + ", Umur: " + passenger.getAge() +
                        ", Jenis Kelamin: " + passenger.getGender() + ", Paspor: " + passenger.getPassportNumber() +
                        ", KTP: " + passenger.getKtpNumber());
            }
        }
    }

    @Override
    public void run() {
        showMainMenu();
    }
}
