package shop;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by artem on 24.01.15.
 */
public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        //new View();
        ControlUser controlUser=new ControlUser();
        controlUser.getUsers();
    }
}
