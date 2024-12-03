package config;

import java.sql.Connection;

public class Database {
    //enkapsulasi
    private final String dbName;
    private final String userName;
    private final String password;
    private final String host;
    private final String port;
    private Connection connection;

    public Database(final String dbName, final String userName, final String password, final String host, final String port, final Connection connection) {
        this.dbName = dbName;
        this.userName = userName;
        this.password = password;
        this.host = host;
        this.port = port;
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }
}
