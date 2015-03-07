//
//    import org.junit.Assert;
//    import org.junit.Test;
//    import shop.dbaccess.ConnectionToDB;
//
//    import java.sql.*;
//
//    public class TestDBAccess {
//        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//        final String DB_URL = "jdbc:mysql://localhost:3306/shop";
//        final String USER = "root";
//        final String PASS = "13071995";
//
//        @Test
//        public void testConnectionToBD() throws ClassNotFoundException, SQLException {
//            Class.forName(JDBC_DRIVER);
//            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
//            Assert.assertNotNull(connection);
//        }
//    }
//
