package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    // Enkapsulasi
    private final String dbName;
    private final String userName;
    private final String password;
    private final String host;
    private final String port;

    // Koneksi database
    private Connection connection;

    // Konstruktor untuk konfigurasi database
    public Database(final String dbName, final String userName, final String password, final String host, final String port) {
        this.dbName = dbName;
        this.userName = userName;
        this.password = password;
        this.host = host;
        this.port = port;
    }

    // Membuat koneksi database
    public void connect() throws SQLException {
        // Format URL JDBC
        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
        try {
            connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Koneksi ke database berhasil!");
        } catch (SQLException e) {
            System.out.println("Gagal membuat koneksi: " + e.getMessage());
            throw e; // Melempar exception ke pemanggil untuk penanganan lebih lanjut
        }
    }

    // Mendapatkan koneksi
    public Connection getConnection() {
        return connection;
    }

    // Menutup koneksi
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Koneksi ditutup.");
            } catch (SQLException e) {
                System.out.println("Gagal menutup koneksi: " + e.getMessage());
            }
        }
    }
}
