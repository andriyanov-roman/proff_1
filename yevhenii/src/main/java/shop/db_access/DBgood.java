package shop.db_access;

import shop.Good;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by eugene on 18.02.15.
 */
public class DBgood implements DAO<exceptions.Good> {



    @Override
    public void executeUpdate(exceptions.Good good) throws SQLException {
        Connection connection = DBConnection.createConnection();
        String sqlUpdate = "insert into shop.goods (good_name,good_quantity,barcode,good_type) values (?,?,?,?)";
        System.out.println("added to base");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, good.getName());
            preparedStatement.setInt(2, good.getQuantity());
            preparedStatement.setLong(3, good.getCode());
            preparedStatement.setString(4, good.getType());
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }

    }
}
