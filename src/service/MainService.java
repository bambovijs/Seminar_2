package service;

import model.Course;
import model.CourseGradeType;
import model.Degree;
import model.Faculty;
import model.Grade;
import model.Profesor;
import model.Student;

public class MainService {
    public static void main(String[] args) {
        Student st1 = new Student();
        System.out.println(st1);
        Student st2 = new Student("Jānis", "Bērziņš", Faculty.Unknown, "101010-10101");
        System.out.println(st2);

        Profesor pr1 = new Profesor();
        System.out.println(pr1);
        Profesor pr2 = new Profesor("Ra", "Ba", Degree.Master);
        System.out.println(pr2);

        Course c1 = new Course();
        System.out.println(c1);
        Course c2 = new Course("Programmesana timekli", 4, CourseGradeType.EXAM, pr2);
        System.out.println(c2);
        Course c3 = new Course("Difrencialvienadojumi", 2, CourseGradeType.EXAM, pr1);
        System.out.println(c3);

        Grade gr1 = new Grade();
        System.out.println(gr1);
        Grade gr2 = new Grade(10, st2, c2);
        System.out.println(gr2);
        Grade gr3 = new Grade(6, st1, c3);
        System.out.println(gr3);

    }
}
