package shop.DAOInterfaces;


import shop.Good;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public interface GoodDAO {
    public void executeUpdate(Good good) throws SQLException, ClassNotFoundException;
    public Set<Good> selectGood() throws SQLException;
}
