package shop.db_access;

import java.sql.SQLException;
import java.util.Set;

/**
 * Created by eugene on 15.02.15.
 */
public interface DAO<T> {

    public void executeUpdate(T t) throws SQLException;
    public Set<T> selectAll();

}
