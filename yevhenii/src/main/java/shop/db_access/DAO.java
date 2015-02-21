package shop.db_access;

import java.sql.SQLException;

/**
 * Created by eugene on 15.02.15.
 */
public interface DAO<T> {
    Object i = DBConnection.getInstance();
    public void executeUpdate(T t) throws SQLException;

}
