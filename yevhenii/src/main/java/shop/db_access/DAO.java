package shop.db_access;

/**
 * Created by eugene on 15.02.15.
 */
public interface DAO<T> {
    public void executeUpdate(T t);
    public void executeSelect(T t);
}
