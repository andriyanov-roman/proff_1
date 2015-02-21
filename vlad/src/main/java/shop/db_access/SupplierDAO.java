package shop.db_access;

import database.GenericDAO;
import shop.goods.Good;
import shop.supplier.Supplier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class SupplierDAO implements GenericDAO<Supplier> {
    static final String supplierUpdate = "insert into shop.supplier (supp_name, good_type, good_id) values (?,?,?)";
    static final String selectAll = "select * from shop.supplier";

    @Override
    public void executeUpdate(Supplier supplier) {
        try (PreparedStatement preparedStatement = DBAccessProcessor.getDBConnection().prepareStatement(supplierUpdate)) {
            preparedStatement.setString(1, supplier.getName());
            preparedStatement.setString(2, supplier.getGoodType());
            preparedStatement.setInt(3, supplier.getGoodID());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<Supplier> selectAll() {
        Set<Supplier> suppliers = new HashSet<>();
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = DBAccessProcessor.getDBConnection().prepareStatement(selectAll)) {
            resultSet = preparedStatement.executeQuery();
            try {
                while (resultSet.next()) {
                    suppliers.add(new Supplier(resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4)));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suppliers;
    }
}
