package shop;

import hiber.HbFactory;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import shop.dao.GoodsDAO;
import shop.dbaccess.ConnectionToDB;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ControlUser {
//    String sql = "SELECT * FROM shop.user";
//    ConnectionToDB connectionToDB = ConnectionToDB.getDbCon();
//    private static SessionFactory factory;

    //    public ArrayList<User> getUsers() throws SQLException {
//
//        ResultSet resultSet = connectionToDB.querys(sql);
//
//        ArrayList<User> users = new ArrayList<>();
//        while (resultSet.next()) {
//            User user = new User();
//            int id = resultSet.getInt("id");
//            String login = resultSet.getString("login");
//            String password = resultSet.getString("passwordd");
//            user.setLogin(login);
//            user.setPassword(password);
//            users.add(user);
//            System.out.println(user.toString());
//        }
//        return users;
//    }

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
