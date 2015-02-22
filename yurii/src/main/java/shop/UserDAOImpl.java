package shop;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;

/**
 * Created by Таня on 22.02.2015.
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public void executeUpdate(User user) throws SQLException, ClassNotFoundException {
        try {
            String sqlUpdate = "insert into users (user_login, user_password) values (?,?)";
            PreparedStatement preparedStatement = ConnectDB.getConnectoin().prepareStatement(sqlUpdate);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setInt(2, Integer.parseInt(user.getPasword()));
            preparedStatement.execute();
        } finally {
            ConnectDB.getConnectoin().close();
        }
    }

    @Override
    public HashSet selectUsers() {
        return null;
    }
}

