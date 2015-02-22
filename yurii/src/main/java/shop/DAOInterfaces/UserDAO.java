package shop.DAOInterfaces;

import shop.User;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public interface UserDAO {
    public void executeUpdate(User user) throws SQLException, ClassNotFoundException;
    public HashSet<User> selectFromUsers() throws SQLException;
}
