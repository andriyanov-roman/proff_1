package shop;


import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public interface GoodDAO {
    public void executeUpdate(Good good) throws SQLException, ClassNotFoundException;
    // сделать еще три метода CRUD !!!
    public Set<Good> selectGood() throws SQLException;
}
