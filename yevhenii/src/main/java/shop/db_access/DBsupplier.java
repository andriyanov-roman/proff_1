package shop.db_access;

import shop.user.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

/**
 * Created by eugene on 18.02.15.
 */
public class DBsupplier implements DAO<Supplier> {
    @Override
    public void executeUpdate(Supplier supplier) throws SQLException {
        Connection connection = DBConnection.createConnection();
        String sqlUpdate = "insert into shop.supplier (supplier_name,goods_type,goods_id) values (?,?,?)";
        System.out.println("added to base");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, supplier.getName());
            preparedStatement.setString(2, supplier.getGoodType());
            preparedStatement.setLong(3, supplier.getGoodId());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }

    }

    @Override
    public Set<Supplier> selectAll() {
        return null;
    }
}

