package university;

import java.util.Calendar;
import java.util.Scanner;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class LoadInfoToDB {
    public static Scanner scanner = new Scanner(System.in);

    public static void consolRead() throws ParseException, SQLException {
        System.out.println("enter name");
        Student s = new Student();
        while (scanner.hasNext()) {
            String name = scanner.next();
            s.setName(name);
            System.out.println("enter second name");
            String secondName = scanner.next();
            s.setSecondName(secondName);
            System.out.println("Enter stipent");
            String stipend = scanner.next();
            s.setStipend(Integer.parseInt(stipend));
            System.out.println("Enter kurs");
            String kurs = scanner.next();
            s.setKurs(Integer.parseInt(kurs));
            System.out.println("Enter city");
            String city = scanner.next();
            s.setCity(city);
            System.out.println("Enter Birthdate");
            String date = scanner.next();
            s.setDate(Date.valueOf(date));
            System.out.println("Enter univers_id");
            String id = scanner.next();
            s.setUnivers_id(Integer.parseInt(id));
            execute(s);
            System.out.println(" Succesful!!!");
            System.out.println(s.toString());
            consolRead();
        }
    }

    public static void execute(Student student) throws SQLException {
        try {
            String sql = "insert into university.students (student_name,student_second_name, stipend, kurs, city, birthday, univers_id ) values (?,?,?,?,?,?,?) ";
            PreparedStatement statement = ConnectionToUniversityDB.getConnection().prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setString(2, student.getSecondName());
            statement.setInt(3, student.getStipend());
            statement.setInt(4, student.getKurs());
            statement.setString(5, student.getCity());
            statement.setDate(6, student.getDate());
            statement.setInt(7, student.getUnivers_id());
            statement.execute();
        } finally {
            ConnectionToUniversityDB.getConnection().close();
        }
    }

    public static void main(String[] args) throws ParseException, SQLException {
        consolRead();
    }
}
