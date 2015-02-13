package test.io.io;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        User u = new User();
        u.setAge(25);
        u.setPassword("sefsddf");
        u.setName("Artem");
        u.setLogin("Sloupok");
        try {

            FileOutputStream out = new FileOutputStream("/home/artem/proff_repos/proff_1/artem/src/main/java/test/io/test");
            ObjectOutputStream oout = new ObjectOutputStream(out);
            oout.writeObject(u);
            oout.close();
            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream("/home/artem/proff_repos/proff_1/artem/src/main/java/test/io/test"));
            User u1=(User)ois.readObject();
            System.out.println(u1.getPassword());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
