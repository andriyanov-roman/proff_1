package shop.DAOInterfaces;

import shop.Supplier;

import java.sql.SQLException;
import java.util.HashSet;

/**
 * Created by Таня on 22.02.2015.
 */
public interface SupplierDao {
    public void executeUpdate(Supplier supplier)throws SQLException,ClassNotFoundException;
    public HashSet<Supplier> selectFromSuppliers()throws SQLException;
}
