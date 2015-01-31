package tests.io;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setPassword("1313123");
        user.setName("Vasya");
        user.setAge(12);
        user.setLogin("PussyRider");
        user.setSurname("Krasavchik");

        try {
            FileOutputStream out = new FileOutputStream("/home/vladislav/proff_repos/proff_1/vlad/src/main/java/files/testSer");
            ObjectOutputStream out1 = new ObjectOutputStream(out);
            out1.writeObject(user);
            out1.close();

            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream("/home/vladislav/proff_repos/proff_1/vlad/src/main/java/files/testSer"));
            User user1 = (User) ois.readObject();
            System.out.println(user1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void ioTest() {
        try (InputStream inStream = new FileInputStream("/home/vladislav/proff_repos/proff_1/vlad/src/main/java/files/test");
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inStream)) {
            int b;
            while (true) {
                b = bufferedInputStream.read();
                if (b != -1) {
                    System.out.print((char) b);
                } else {
                    break;
                }
            }
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

}
