package views;

import entities.FlightRoute;
import services.FlightRouteService;

import java.util.Scanner;

public class FlightRouteTerminalViewImpl implements FlightRouteView {
    private final FlightRouteService flightRouteService;

    public FlightRouteTerminalViewImpl(FlightRouteService flightRouteService) {
        this.flightRouteService = flightRouteService;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Rute Penerbangan");
            System.out.println("2. Hapus Rute Penerbangan");
            System.out.println("3. Edit Rute Penerbangan");
            System.out.println("4. Tampilkan Semua Rute Penerbangan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Menambah rute penerbangan
                    System.out.print("Masukkan Kota Keberangkatan: ");
                    String departureCity = scanner.next();
                    System.out.print("Masukkan Kota Tujuan: ");
                    String arrivalCity = scanner.next();
                    System.out.print("Masukkan Waktu Keberangkatan (yyyy-MM-dd HH:mm): ");
                    String departureTime = scanner.next();
                    System.out.print("Masukkan Waktu Kedatangan (yyyy-MM-dd HH:mm): ");
                    String arrivalTime = scanner.next();

                    FlightRoute route = new FlightRoute(0, departureCity, arrivalCity, departureTime, arrivalTime);
                    route.setDepartureCity(departureCity);
                    route.setArrivalCity(arrivalCity);
                    route.setDepartureTime(departureTime);
                    route.setArrivalTime(arrivalTime);
                    flightRouteService.addFlightRoute(route);
                    System.out.println("Rute penerbangan berhasil ditambahkan.");
                    break;
                case 2:
                    // Menghapus rute penerbangan
                    System.out.print("Masukkan ID rute yang ingin dihapus: ");
                    int removeId = scanner.nextInt();
                    boolean removed = flightRouteService.removeFlightRoute(removeId);
                    if (removed) {
                        System.out.println("Rute penerbangan berhasil dihapus.");
                    } else {
                        System.out.println("Rute penerbangan tidak ditemukan.");
                    }
                    break;
                case 3:
                    // Mengedit rute penerbangan
                    System.out.print("Masukkan ID rute yang ingin diedit: ");
                    int editId = scanner.nextInt();
                    System.out.print("Masukkan Kota Keberangkatan: ");
                    String newDepartureCity = scanner.next();
                    System.out.print("Masukkan Kota Tujuan: ");
                    String newArrivalCity = scanner.next();
                    System.out.print("Masukkan Waktu Keberangkatan: ");
                    String newDepartureTime = scanner.next();
                    System.out.print("Masukkan Waktu Kedatangan: ");
                    String newArrivalTime = scanner.next();

                    FlightRoute updatedRoute = new FlightRoute();
                    updatedRoute.setId(editId);
                    updatedRoute.setDepartureCity(newDepartureCity);
                    updatedRoute.setArrivalCity(newArrivalCity);
                    updatedRoute.setDepartureTime(newDepartureTime);
                    updatedRoute.setArrivalTime(newArrivalTime);
                    boolean edited = flightRouteService.editFlightRoute(updatedRoute);
                    if (edited) {
                        System.out.println("Rute penerbangan berhasil diedit.");
                    } else {
                        System.out.println("Rute penerbangan tidak ditemukan.");
                    }
                    break;
                case 4:
                    // Menampilkan semua rute penerbangan
                    FlightRoute[] allRoutes = flightRouteService.getAllFlightRoutes();
                    for (FlightRoute r : allRoutes) {
                        System.out.println("ID: " + r.getId() + " | " + r.getDepartureCity() + " -> " + r.getArrivalCity() +
                                " | Keberangkatan: " + r.getDepartureTime() + " | Kedatangan: " + r.getArrivalTime());
                    }
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
