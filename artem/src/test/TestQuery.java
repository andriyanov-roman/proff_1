import hiber.HbFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;


import java.util.List;

/**
 * Created by artem on 14.03.15.
 */
public class TestQuery {
    Session session;

    final String sql = "FROM User WHERE login=:login";

    @Test
    public void getUser(){
        session = HbFactory.getInstance().getSession();
        Query q=session.createQuery(sql);
        q.setParameter("login","ok");
        List result=q.list();
        for (int i = 0; i <result.size() ; i++) {
            System.out.println(result.get(i).toString());
        }
    }
}
