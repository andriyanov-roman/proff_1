package shop.control;

import hiber.HbFactory;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import shop.entity.User;

import java.sql.SQLException;
import java.util.List;

public class ControlUser {


    Session session;

    public List<User> getUsers() {
        SessionFactory sessions = new Configuration().configure().buildSessionFactory();
        Session session = sessions.openSession();
        session.beginTransaction();
        session.getTransaction().commit();
        List<User> users = (List<User>) session.createCriteria(User.class).list();
        return users;
    }

    public boolean checkUser(String login, String password) throws SQLException {
        boolean check = false;
        for (int i = 0; i < getUsers().size(); i++) {
            if (getUsers().get(i).getLogin().equals(login) && getUsers().get(i).getPassword().equals(password)) {
                check = true;
            }
        }
        return check;
    }

    public void registationUser(User user) {
        session = HbFactory.getInstance().getSession();
        try {
            session.getTransaction().begin();
            session.save(user);
            session.getTransaction().commit();
        } finally {
            if (session != null) session.close();
        }
    }


//    public  ArrayList<String[]> getStrings(String path) throws FileNotFoundException {
//        ArrayList<String> stringList = new ArrayList<>();
//        ArrayList<String[]> strings = new ArrayList<>();
//        File file = new File(path);
//        Scanner s = new Scanner(file);
//        while (s.hasNext()) {
//            stringList.add(s.next());
//        }
//        for (int i = 0; i < stringList.size(); i++) {
//            strings.add(stringList.get(i).split(":"));
//        }
//        return strings;
//    }
}
