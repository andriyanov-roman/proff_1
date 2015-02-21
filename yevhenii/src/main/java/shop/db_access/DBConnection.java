package shop.db_access;

import exceptions.Good;

import java.sql.*;

/**
 * Created by eugene on 15.02.15.
 */
public class DBConnection {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/shop";
    static final String USER = "root";
    static final String PASS = "kjkszpj";

    private static DBConnection instance = new DBConnection();

    private DBConnection() {
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public static Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }




        /*String sqlUpdate = "insert into shop.goods (good_name, good_quantity, barcode, good_type) values (?,?,?,?)";

        String sql = "SELECT * FROM goods";



        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        PreparedStatement prepared = connection.prepareStatement(sqlUpdate);

        prepared.setString(1, "good_name");
        prepared.setString(2, "good_quantity");
        prepared.setString(3, "barcode");
        prepared.setString(4, "good_type");

        prepared.setString(1, "dolar");
        prepared.setInt(2, 1);
        prepared.setInt(3, 213);
        prepared.setString(4, "money");

        prepared.executeUpdate();
        while (result.next()) {
            String name = result.getString("good_name");
            int quantity = result.getInt("good_quantity");
            int barcode = result.getInt("barcode");
            String type = result.getString("good_type");
            Good good = new Good(name, quantity, barcode, type);
            System.out.println(good.toString());
        }
        prepared.close();
    }*/


}


