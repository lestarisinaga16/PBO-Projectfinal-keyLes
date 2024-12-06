package views;

import entities.Passengers;
import services.PassengersService;

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
            System.out.println("\nMENU:");
            System.out.println("1. Tambah Data Penumpang");
            System.out.println("2. Tampilkan Daftar Penumpang");
            System.out.println("3. Tampilkan Daftar Rute");
            System.out.println("4. Tambah Rute Penerbangan");
            System.out.println("5. Edit Rute Penerbangan");
            System.out.println("6. Hapus Rute Penerbangan");
            System.out.println("7. Edit Informasi Penumpang");
            System.out.println("8. Keluar dari Sistem");
            String selectedMenu = input("Pilih menu");

            switch (selectedMenu) {
                case "1":
                    showMenuAddPassenger();
                    break;
                case "2":
                    showPassengerList();
                    break;
                case "3":
                    // Tampilkan Daftar Rute (belum diimplementasikan)
                    break;
                case "4":
                    // Tambah Rute Penerbangan (belum diimplementasikan)
                    break;
                case "5":
                    // Edit Rute Penerbangan (belum diimplementasikan)
                    break;
                case "6":
                    // Hapus Rute Penerbangan (belum diimplementasikan)
                    break;
                case "7":
                    showPassengerList();
                    String selectedPassengerToEdit = input("Pilih nomor penumpang yang akan diedit (x untuk batal)");
                    if (!selectedPassengerToEdit.equalsIgnoreCase("x")) {
                        editPassengerInfo(Integer.parseInt(selectedPassengerToEdit));
                    }
                    break;
                case "8":
                    System.out.println("Keluar dari aplikasi.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilih menu dengan benar");
            }
        }
    }

    // Dalam PassengerTerminalViewImpl, pastikan data ditambahkan dengan benar
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

        passengerService.addPassenger(passenger);  // Pastikan service dipanggil
        System.out.println("Penumpang berhasil ditambahkan.");
    }




    public void showPassengerList() {
        System.out.println("DAFTAR PENUMPANG");
        Passengers[] passengerList = passengerService.getPassengerList();

        if (passengerList.length == 0) {
            System.out.println("Tidak ada penumpang yang tersedia.");
        } else {
            for (int i = 0; i < passengerList.length; i++) {
                Passengers passenger = passengerList[i];
                System.out.println((i + 1) + ". Nama: " + passenger.getName() +
                        ", Umur: " + passenger.getAge() +
                        ", Jenis Kelamin: " + passenger.getGender() +
                        ", Paspor: " + passenger.getPassportNumber() +
                        ", KTP: " + passenger.getKtpNumber());
            }
        }
    }


    public void editPassengerInfo(int number) {
        System.out.println("MENGEDIT DATA PENUMPANG");
        String newName = input("Masukkan nama baru");
        String newAge = input("Masukkan umur baru");
        String newGender = input("Masukkan jenis kelamin baru (L/P)");
        String newPassportNumber = input("Masukkan nomor paspor baru");
        String newKtpNumber = input("Masukkan nomor KTP baru");

        Passengers updatedPassenger = new Passengers();
        updatedPassenger.setName(newName);
        updatedPassenger.setAge(Integer.parseInt(newAge));  // Validasi umur
        updatedPassenger.setGender(newGender);
        updatedPassenger.setPassportNumber(newPassportNumber);
        updatedPassenger.setKtpNumber(newKtpNumber);

        boolean isEditSuccess = passengerService.editPassenger(number, updatedPassenger);  // Pastikan parameter yang dikirim benar
        if (isEditSuccess) {
            System.out.println("Berhasil mengedit data penumpang.");
        } else {
            System.out.println("Gagal mengedit data penumpang.");
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


    @Override
    public void run() {
        showMainMenu();
    }
}
