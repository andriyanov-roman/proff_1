package shop.users;

import shop.db_access.UserDAO;

public class UserUtility {
    UserDAO userDAO = new UserDAO();

    public void addUser(User user) {
        userDAO.executeUpdate(user);
    }
}
