package service;

import java.util.ArrayList;

import model.Course;
import model.CourseGradeType;
import model.Degree;
import model.Faculty;
import model.Grade;
import model.Profesor;
import model.Student;

public class MainService {
    private static ArrayList<Student> allStudentsList = new ArrayList<>();
    private static ArrayList<Profesor> allProfesorList = new ArrayList<>();
    private static ArrayList<Course> allCoursesList = new ArrayList<>();
    private static ArrayList<Grade> allGradeList = new ArrayList<>();
    public static void main(String[] args) {

        //TODO create 4 arrays and add all elements
        // Student[] allStudents = new Student[6];
        // Profesor[] profesors = new Profesor[6];
        // Course[] courses = new Course[6];
        // Grade[] grades = new Grade[6];

        Student st1 = new Student();
        Student st2 = new Student("Jānis", "Bērziņš", Faculty.Unknown, "101010-10101");

        Student[] allStudents = {st1, st2};

        for(Student temp : allStudents){
            System.out.println(temp);
        }

        //ArrayList<Student> allStudentsList = new ArrayList<>();
        allStudentsList.add(st1);
        allStudentsList.add(st2);

        for(Student temp : allStudentsList){
            System.out.println(temp);
        }


        Profesor pr1 = new Profesor();
        Profesor pr2 = new Profesor("Ra", "Ba", Degree.Master);

       //Profesor[] allProfesors = {pr1, pr2};

        for(Profesor temp : allProfesorList){
            System.out.println(temp);
        }

        ArrayList<Profesor> allProfesorList = new ArrayList<>();
        allProfesorList.add(pr1);
        allProfesorList.add(pr2);
        
        for(Profesor temp : allProfesorList){
            System.out.println(temp);
        }

        Course c1 = new Course();
        Course c2 = new Course("Programmesana timekli", 4, CourseGradeType.EXAM, pr2);
        Course c3 = new Course("Difrencialvienadojumi", 2, CourseGradeType.EXAM, pr1);

        Course[] allCourses = {c1, c2, c3};

        for(Course temp : allCourses){
            System.out.println(temp);
        }

        //ArrayList<Course> allCoursesList = new ArrayList<>();
        allCoursesList.add(c1);
        allCoursesList.add(c2);
        allCoursesList.add(c3);

        for(Course temp : allCoursesList){
            System.out.println(temp);
        }

        Grade gr1 = new Grade();
        Grade gr2 = new Grade(10, st2, c2);
        Grade gr3 = new Grade(6, st1, c3);

        Grade[] allGrades = {gr1, gr2, gr3};

        for(Grade temp : allGrades){
            System.out.println(temp);
        }

        //ArrayList<Grade> allGradeList = new ArrayList<>();
        allGradeList.add(gr1);
        allGradeList.add(gr2);
        allGradeList.add(gr3);

        for(Grade temp : allGradeList){
            System.out.println(temp);
        }

        System.out.println("---------------------------------");
        for(Student temp : allStudentsList){
            System.out.println(temp.getName() + ": " + calculateAVGGrade(temp));
        }

        System.out.println("---------------------------------");
        for(Course temp : allCoursesList){
            System.out.println(temp.getTitle() + " : " + calculateAVGGradeInCourse(temp));
        } 

        System.out.println("---------------------------------");
        for(Student temp : allStudentsList){
            System.out.println(temp.getName() + " : " + calculateWeightedAVGGrade(temp));
        } 
    }

    private static float calculateAVGGrade(Student student){
        if(student != null){
            int gradesSum = 0;
            int gradesCounter = 0;

            for(Grade temp : allGradeList){
                if(temp.getStudent().equals(student)){
                    gradesSum += temp.getGradeValue();
                    gradesCounter++;
                }
            }

            return gradesSum/((float)gradesCounter);
        }
        else{
            return 0;
        }
    }

    private static float calculateAVGGradeInCourse(Course course){
        if(course != null){
            int gradesSum = 0;
            int gradesCounter = 0;

            for(Grade temp : allGradeList){
                if(temp.getCourse().equals(course)){
                    gradesSum += temp.getGradeValue();
                    gradesCounter++;
                }
            }

            return gradesSum/((float)gradesCounter);
        }
        else{
            return 0;
        }
    }

    private static float calculateWeightedAVGGrade(Student student){
        if(student != null){
            float gradesSum = 0;
            int creditPointsCounter = 0;
            for(Grade temp : allGradeList){
                if(temp.getStudent().equals(student)){
                    gradesSum += (temp.getGradeValue()*temp.getCourse().getCreditPoints());
                    creditPointsCounter += temp.getCourse().getCreditPoints();
                }
            }

            return gradesSum/creditPointsCounter;
        }
        else {
            return 0.0f;
        }
    }
}
