package config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private final String dbName;
    private final String userName;
    private final String password;
    private final String host;
    private final String port;
    private Connection connection;


    public Database(final String dbName, final String userName, final String password, final String host, final String port) {
        this.dbName = dbName;
        this.userName = userName;
        this.password = password;
        this.host = host;
        this.port = port;
    }


    public Connection getConnection() {
        return connection;
    }


    public void setup() {
        String mysqlConnUrlTemplate = "jdbc:mysql://%s:%s/%s?useSSL=false";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(String.format(mysqlConnUrlTemplate, host, port, dbName), userName, password);
            System.out.println("Database connected!");

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Gagal terhubung ke database: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }


    public void close() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Koneksi ke database berhasil ditutup.");
            } catch (SQLException e) {
                System.err.println("Gagal menutup koneksi database: " + e.getMessage());
            }
        }
    }
}