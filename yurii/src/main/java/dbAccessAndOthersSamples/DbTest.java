package dbAccessAndOthersSamples;//package dbAccessAndOthersSamples;
//
//import shop.Good;
//import java.sql.*;
//
//public class DbTest {
//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost:3306/shop";
//    static final String USER = "root";
//    static final String PASS = "yurceh12";
//
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
//        Statement statement = connection.createStatement();
//        String sql = "SELECT * FROM goods";
//        ResultSet result = statement.executeQuery(sql);
//        while (result.next()) {
//
////            String name = result.getString("good_name");
////            int quantity = result.getInt("good_qty");
////            int barcode = result.getInt("barcode");
////            String type = result.getString("good_type");
////            Good good = new Good();
////            good.setAmount(quantity);
////            good.setBarcode(barcode);
////            good.setType(type);
////            good.setName(name);
////            System.out.println(good.toString());
//    }
//
//    String sqlUpdate = "insert into goods (good_name,good_qty,barcode,good_type) values (?,?,?,?)";
//    PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
//
//    Good good = new Good();
//    good.setName("cookies");
//    good.setAmount(10);
//        good.setBarcode(2747492);
//        good.setType("sweets");
//        preparedStatement.setString(1, good.getName());
//        preparedStatement.setInt(2, good.getAmount());
//        preparedStatement.setLong(3, good.getBarcode());
//        preparedStatement.setString(4, good.getType());
//        preparedStatement.execute();
//
//
//
//
//
//    }
//}
