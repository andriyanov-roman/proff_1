package test_p.io_test;



import javax.sound.sampled.AudioInputStream;
import java.io.*;

/**
 * Created by eugene on 31.01.15.
 */
public class Main {
    public void lele() {
        InputStream inStream = null;
        AudioInputStream audioInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {

            inStream = new FileInputStream("/home/eugene/" +
                    "proff_repos/proff_1/yevhenii/src/main/java/" +
                    "test_p/io_test/io_test_file");
            bufferedInputStream = new BufferedInputStream(inStream);
            int b;
            while (true) {
                b = inStream.read();
                if (b != -1) {
                    System.out.println((char) b);
                } else {
                    break;
                }
            }
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }}
   /* public static void main(String[] args) {
   User user = new User();
        user.setName("Artem");
        user.setSecondName("Balandin");
        user.setLogin("Balasha");
        user.setPassword("Pisos");
        user.setAge(12);
        try {

            FileOutputStream out = new FileOutputStream("/home/eugene/test.txt");
            ObjectOutputStream oout = new ObjectOutputStream(out);
            oout.writeObject(user);
            oout.close();

            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream("/home/eugene/test.txt"));
            User user1 = (User)ois.readObject();

            System.out.println(user1);
            //System.out.println("" + (User)ois.readObject());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

}
}*/