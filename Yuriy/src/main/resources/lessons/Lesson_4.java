package lessons;

import university.Student;

public class Lesson_4 {
    public static void main(String[] args) {

        Student s = new Student();
        s.name = "ivan";
        Student s1 = s;
        s1.name = "vasya";
        System.out.println(s.name);
        System.out.println(s1.name);
    }

}
