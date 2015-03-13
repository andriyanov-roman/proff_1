package shop.users;

import org.hibernate.Session;
import sessions_factory.HbFactory;

public class UserUtility {

    public void addUser(User user) {
        Session session = HbFactory.instance().getSession();
        session.getTransaction().begin();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
}