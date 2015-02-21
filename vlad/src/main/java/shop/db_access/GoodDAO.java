package shop.db_access;

import database.GenericDAO;
import shop.goods.Good;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class GoodDAO implements GenericDAO<Good> {
    static final String goodUpdate = "insert into shop.goods (good_name, good_quantity, barcode, good_type) values (?,?,?,?)";
    static final String selectAll = "select * from shop.goods";

    @Override
    public void executeUpdate(Good good) {
        try (PreparedStatement preparedStatement = DBAccessProcessor.getDBConnection().prepareStatement(goodUpdate)) {
            preparedStatement.setString(1, good.getName());
            preparedStatement.setInt(2, good.getQuantity());
            preparedStatement.setLong(3, good.getBarcode());
            preparedStatement.setString(4, good.getType());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<Good> selectAll() {
        Set<Good> goods = new HashSet<>();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = DBAccessProcessor.getDBConnection().prepareStatement(selectAll)) {
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
