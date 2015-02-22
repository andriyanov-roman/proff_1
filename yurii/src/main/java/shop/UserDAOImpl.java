package shop;

import shop.DAOInterfaces.UserDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

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
    public HashSet<User> selectFromUsers() throws SQLException {
        try {
            HashSet<User> usersSet = new HashSet<>();
            String sql = "SELECT * FROM users";
            PreparedStatement statement = ConnectDB.getConnectoin().prepareStatement(sql);
            ResultSet resalt = statement.executeQuery(sql);

            while (resalt.next()) {
                String login = resalt.getString("user_login");
                String password = resalt.getString("user_password");
                User user = new User();
                user.setLogin(login);
                user.setPasword(password);
                usersSet.add(user);
            }
            return usersSet;
        } finally {
            ConnectDB.getConnectoin().close();
        }
    }
}

