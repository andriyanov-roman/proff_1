package shop.db_access;

import java.sql.*;

public class DBAccessProcessor {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/shop";
    static final String LOGIN = "root";
    static final String PASSWORD = "";

    private static Connection connection;

    static {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (Exception e) {

        }
    }

    public static Connection getDBConnection() {
        return connection;
    }

}

