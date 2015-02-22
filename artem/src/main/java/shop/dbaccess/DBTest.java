package shop.dbaccess;

import shop.Good;

import java.sql.*;

/**
 * Created by artem on 15.02.15.
 */
public class DBTest {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/shop";
    static final String USER = "root";
    static final String PASS = "13071995";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM shop.goods";
        //ResultSet result = statement.executeQuery(sql);
//        while (result.next()) {
//            Good good = new Good();
//            int id = result.getInt("id");
//            String name = result.getString("good_name");
//            String type = result.getString("good_type");
//            long barcode = result.getLong("barcode");
//            int number = result.getInt("good_number");
//            good.setNumber(number);
//            good.setBarcode(barcode);
//            good.setType(type);
//            good.setName(name);
//            System.out.println(id + "=" + good.toString());
//            /*int id = result.getInt("id");
//            String name = result.getString("supplier_name");
//            String type = result.getString("goods_type");
//            int number = result.getInt("goods_id");
//            System.out.println(id + " " + name + " " + type + " " + number);*/
//        }
        String sqlUpdate = "INSERT INTO shop.goods (good_name, good_number, barcode, good_type) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
        Good good = new Good();
        good.setName("qw");
        good.setNumber(1);
        good.setType("wqrwwqr");
        good.setBarcode(213442114);
        preparedStatement.setString(1, good.getName());
        preparedStatement.setInt(2, good.getNumber());
        preparedStatement.setLong(3, good.getBarcode());
        preparedStatement.setString(4, good.getType());
        preparedStatement.execute();

    }
}
