//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import shop.Good;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//
//public class TestExecuteUpdate {
//    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    final String DB_URL = "jdbc:mysql://localhost:3306/shop";
//    final String USER = "root";
//    final String PASS = "13071995";
//    String sqlUpdate = "INSERT INTO shop.goods (good_name, good_number, barcode, good_type) VALUES (?,?,?,?)";
//    Connection connection=null;
//
//    @Before
//    public void getConnection() throws ClassNotFoundException, SQLException {
//        Class.forName(JDBC_DRIVER);
//        connection = DriverManager.getConnection(DB_URL, USER, PASS);
//    }
//
//    @After
//    public void closeConnection() throws SQLException {
//        connection.close();
//    }
//
//    @Test(timeout = 1000)
//    public void executeUpdate() throws SQLException {
//        PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
//        Good goods = new Good();
//        goods.setName("asfsa");
//        goods.setType("saffsa");
//        goods.setBarcode(1243);
//        goods.setNumber(21421);
//        preparedStatement.setString(1, goods.getName());
//        preparedStatement.setInt(2, goods.getNumber());
//        preparedStatement.setLong(3, goods.getBarcode());
//        preparedStatement.setString(4, goods.getType());
//        boolean isExecuted =  preparedStatement.execute();
//        Assert.assertFalse(isExecuted);
//    }
//}
