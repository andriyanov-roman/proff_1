package shop.shop_access;

import except.Good;

import java.sql.*;

public class Main {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/shop";
    static final String USER = "root";
    static final String PASS = "admin";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM shop.goods";
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            int id = result.getInt("good_id");
            System.out.println(id);
            String name = result.getString("good_name");
            System.out.println(name);
            int type = result.getInt("good_type");
            System.out.println(type);
            int barcode = result.getInt("good_barcode");
            System.out.println(barcode);
        }
        String sql_Two = "INSERT INTO goods (good_name,good_type,good_barcode) VALUES(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql_Two);
        Good good = new Good("Молочко", 122, 82333, "2");
        preparedStatement.setString(1, good.getTitle());
        preparedStatement.setInt(2, good.getQuantity());
        preparedStatement.setLong(,good.getTitle());
        preparedStatement.executeUpdate();
    }

}


