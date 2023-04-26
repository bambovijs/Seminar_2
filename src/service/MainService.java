package service;

import model.Faculty;
import model.Student;

public class MainService {
    public static void main(String[] args) {
        Student st1 = new Student();
        System.out.println(st1);
        Student st2 = new Student("Jānis", "Bērziņš", Faculty.Unknown, "101010-10101");
        System.out.println(st2);
    }
}
