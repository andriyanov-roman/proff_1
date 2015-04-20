import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import shop.entity.User;

import java.util.List;

/**
 * Created by artem on 10.03.15.
 */
public class TestCheckUsers {


    public List<User> getUserss( ){
        SessionFactory sessions = new Configuration().configure().buildSessionFactory();
        Session session = sessions.openSession();
        session.beginTransaction();
        session.getTransaction().commit();
        List <User> users =(List<User>)session.createCriteria(User.class).list();;

        return users;
    }
    @Test
    public void checkUser() {
        boolean check = false;
        for (int i = 0; i < getUserss().size(); i++) {
            if (getUserss().get(i).getLogin().equals("user") && getUserss().get(i).getPassword().equals("name")) {
                check = true;
            }
        }
        System.out.println(check);
    }
}
