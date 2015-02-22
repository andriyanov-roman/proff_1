package shop;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;


public class SupplierDAOImpl implements SupplierDao {
    @Override
    public void executeUpdate(Supplier supplier) throws SQLException, ClassNotFoundException {
        try {
            String sql = "INSERT INTO supplier (supplier_name, goods_type) values (?,?)";
            PreparedStatement statement = ConnectDB.getConnectoin().prepareStatement(sql);
            statement.setString(1, supplier.getName());
            statement.setString(2, supplier.getType());

            statement.execute();
        } finally {
            ConnectDB.getConnectoin().close();
        }
    }

    @Override
    public HashSet<Supplier> selectFromSuppliers() throws SQLException {
        try {
            HashSet<Supplier> suppliers = new HashSet<>();
            String sql = "SELECT * FROM supplier";
            PreparedStatement statement = ConnectDB.getConnectoin().prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                String name = result.getString("supplier_name");
                String type = result.getString("goods_type");
                Supplier supplier = new Supplier();
                supplier.setName(name);
                supplier.setType(type);
                suppliers.add(supplier);
            }
            return suppliers;

        } finally {
            ConnectDB.getConnectoin().close();
        }
    }
}