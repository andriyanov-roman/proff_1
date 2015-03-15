package shop.users;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sessions_factory.HbFactory;

import java.util.List;

public class UserUtility {

    public void addUser(User user) {
        Session session = HbFactory.instance().getSession();
        session.getTransaction().begin();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public List<User> selectAll(){
        Session session = HbFactory.instance().getSession();
        Query query = session.createQuery("from User");
        List<User> users = query.list();
        session.close();
        return users;
    }

    public static void main(String[] args) {
        UserUtility userUtility = new UserUtility();
        List<User> list = userUtility.selectAll();
        for(User user : list){
            System.out.println(user);
        }
    }
}