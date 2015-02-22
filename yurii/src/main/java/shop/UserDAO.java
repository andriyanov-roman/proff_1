package shop;


import java.sql.SQLException;
import java.util.HashSet;

public interface UserDAO {
    public void executeUpdate(User user) throws SQLException, ClassNotFoundException;
    public HashSet selectUsers();
}
