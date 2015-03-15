
import org.hibernate.Session;
import org.junit.Test;
import sessions_factory.HbFactory;
import shop.users.User;
import shop.users.UserRole;


/**
 * Created by root on 14.03.15.
 */
public class UserTest {
@Test
    public void doShit() throws Exception{
        Session session = HbFactory.instance().getSession();
        session.getTransaction().begin();
        UserRole userRole = new UserRole();
        userRole.setName("admin");
        User user = new User();
        user.setLogin("lelel");
        user.setPassword("wdwwd");
        user.setUserRole(userRole);
        session.save(userRole);
        session.save(user);
        session.getTransaction().commit();
        session.close();

    }
}
