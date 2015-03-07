package shop;

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
import java.util.Scanner;

public class ControlUser {
    String sql = "SELECT * FROM shop.user";
    ConnectionToDB connectionToDB = ConnectionToDB.getDbCon();


//    public void init() throws ServletException {
//        try {
//            resultSet = connectionToDB.querys(sql);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


    public ArrayList<User> getUsers() throws SQLException {

        ResultSet resultSet = connectionToDB.querys(sql);

        ArrayList<User> users = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User();
            int id = resultSet.getInt("id");
            String login = resultSet.getString("login");
            String password = resultSet.getString("passwordd");
            user.setLogin(login);
            user.setPassword(password);
            users.add(user);
            System.out.println(user.toString());
        }
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
