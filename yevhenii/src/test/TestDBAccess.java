import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import shop.db_access.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by eugene on 21.02.15.
 */
public class TestDBAccess {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/shop";
    static final String USER = "root";
    static final String PASS = "kjkszpj";

   public static Connection connection = null;

    @Before
    @Test(timeout = 44)
    public void getDBconnect() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DB_URL, USER, PASS);

    }

    @After
    public void closeConnection() throws SQLException {
        connection.close();
    }
}

