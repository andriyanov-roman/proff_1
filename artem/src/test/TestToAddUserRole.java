import hiber.HbFactory;
import org.hibernate.Session;
import org.junit.Test;
import shop.entity.User;
import shop.userright.UserRole;

/**
 * Created by artem on 14.03.15.
 */
public class TestToAddUserRole {
    Session session;

    @Test
    public void registationUser() throws Exception {
        session = HbFactory.getInstance().getSession();
        User user = new User();
        UserRole userRole = new UserRole();
        userRole.setName("asf");
        user.setPassword("name");
        user.setLogin("user");
        session.getTransaction().begin();
        session.save(userRole);
        session.save(user);
        session.getTransaction().commit();
    }
}
