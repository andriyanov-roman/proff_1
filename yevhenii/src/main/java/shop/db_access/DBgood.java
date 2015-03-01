package shop.db_access;

import shop.Good;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by eugene on 18.02.15.
 */
public class DBgood implements DAO<Good> {

    String selectAll = "SELECT * FROM goods";

    @Override
    public void executeUpdate(Good good) throws SQLException {
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

    @Override

        public Set<Good> selectAll() {
            Set<Good> goods = new HashSet<>();
            ResultSet resultSet = null;
            try (PreparedStatement preparedStatement = DBConnection.createConnection().prepareStatement(selectAll)) {
                resultSet = preparedStatement.executeQuery();
                try {
                    while (resultSet.next()) {
                        goods.add(new Good(resultSet.getString(2), resultSet.getInt(3),
                                resultSet.getInt(4), resultSet.getString(5)));
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return goods;
        }
}
