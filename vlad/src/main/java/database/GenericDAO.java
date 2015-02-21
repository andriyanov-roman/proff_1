package database;

import java.sql.ResultSet;
import java.util.Set;

/**
 * Created by root on 15.02.15.
 */
public interface GenericDAO<T> {
    public void executeUpdate(T t);
    public Set<T> selectAll();

}
