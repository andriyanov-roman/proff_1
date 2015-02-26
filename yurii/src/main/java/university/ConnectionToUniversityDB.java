package university;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToUniversityDB  {

    private ConnectionToUniversityDB() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
    }

    private static ConnectionToUniversityDB toUniversityDB = new ConnectionToUniversityDB();



    public static ConnectionToUniversityDB getToUniversityDB()  {
        if (toUniversityDB == null) {
            toUniversityDB = new ConnectionToUniversityDB();
        }
        return toUniversityDB;
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/University", "root", "yurceh12");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
