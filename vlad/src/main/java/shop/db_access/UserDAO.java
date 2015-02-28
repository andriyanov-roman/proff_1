package shop.db_access;

import database.GenericDAO;
import shop.goods.Good;
import shop.users.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UserDAO implements GenericDAO<User>{
    public static final String userUpdate = "insert into shop.user (login, password) values (?,?)";
    public static final String selectAll = "select * from shop.user";

    @Override
    public void executeUpdate(User user) {
        try (PreparedStatement preparedStatement = DBAccessProcessor.getDBConnection().prepareStatement(userUpdate)) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<User> selectAll() {
        Set<User> users = new HashSet<>();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = DBAccessProcessor.getDBConnection().prepareStatement(selectAll)) {
            resultSet = preparedStatement.executeQuery();
            try {
                while (resultSet.next()) {
                    users.add(new User(resultSet.getString(2), resultSet.getString(3)));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
