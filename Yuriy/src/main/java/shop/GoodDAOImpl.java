package shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GoodDAOImpl implements GoodDAO {
    Connection connection = ConnectDB.getConnectoin();

    @Override
    public void executeUpdate(Good good) throws SQLException, ClassNotFoundException {
        try {
            String sqlUpdate = "insert into goods (good_name,good_qty,barcode,good_type) values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, good.getName());
            preparedStatement.setInt(2, good.getAmount());
            preparedStatement.setLong(3, good.getBarcode());
            preparedStatement.setString(4, good.getType());
            preparedStatement.execute();
        } finally {
            connection.close();
        }
    }
    public   void exeUpdateForUser(User user) throws SQLException, ClassNotFoundException{
        try {
            String sqlUpdate = "insert into users (user_login, user_password) values (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setInt(2, Integer.parseInt(user.getPasword()));
            preparedStatement.execute();
        } finally {
            connection.close();
        }
    }



}
