package service;

import java.util.ArrayList;

import model.Course;
import model.CourseGradeType;
import model.Degree;
import model.Faculty;
import model.Grade;
import model.Profesor;
import model.Student;
import model.Person;

public class MainService {
    // private static ArrayList<Student> allStudentsList = new ArrayList<>();
    // private static ArrayList<Profesor> allProfesorList = new ArrayList<>();

    private static ArrayList<Person> allPersons = new ArrayList<>();
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
        Student st3 = new Student("Līga", "Priede", Faculty.Unknown, "101010-10101");

        allPersons.add(st1);
        allPersons.add(st2);
        allPersons.add(st3);

        Profesor pr1 = new Profesor();
        Profesor pr2 = new Profesor("Ra", "Ba","101010-10100", Degree.Master);
        Profesor pr3 = new Profesor("Karina", "Skirmante", "101010-10100", Degree.Master);

        allPersons.add(pr1);
        allPersons.add(pr2);
        allPersons.add(pr3);

        for(Person temp : allPersons){
            System.out.println(temp.toString());
        }
        System.out.println("----------------------------------------");

        Course c1 = new Course();
        Course c2 = new Course("Programmesana timekli", 4, CourseGradeType.EXAM, pr3);
        Course c3 = new Course("Programmesana timekli X2", 4, CourseGradeType.EXAM, pr2);
        Course c4 = new Course("Difrencialvienadojumi", 2, CourseGradeType.EXAM, pr1);

        allCoursesList.add(c1);
        allCoursesList.add(c2);
        allCoursesList.add(c3);
        allCoursesList.add(c4);

        Grade gr1 = new Grade();
        Grade gr2 = new Grade(10, st2, c2);
        Grade gr3 = new Grade(6, st1, c3);

        Grade[] allGrades = {gr1, gr2, gr3};

        for(Grade temp : allGrades){
            System.out.println(temp);
        }

        allGradeList.add(gr1);
        allGradeList.add(gr2);
        allGradeList.add(gr3);

        for(Grade temp : allGradeList){
            System.out.println(temp);
        }
 
        System.out.println("--------------AVERAGE GRADE-------------------");
        for(Person temp : allPersons){
            if(temp instanceof Student){
                Student tempStudent = (Student)temp;
                System.out.println(tempStudent.getName() + ": " + calculateAVGGrade(tempStudent));
            }
            
        }

        System.out.println("--------------AVERAGE GRADE IN COURSE-------------------");
        for(Course temp : allCoursesList){
            System.out.println(temp.getTitle() + " : " + calculateAVGGradeInCourse(temp));
        } 
 
        System.out.println("-------------AVERAGE GRADE--------------------");
        for(Person temp : allPersons){
            if(temp instanceof Student){
                Student tempStudent = (Student)temp;
                System.out.println(temp.getName() + ": " + calculateWeightedAVGGrade(tempStudent));
            }
        } 

        System.out.println("---------COURSE COUNT------------------------");
        for(Person temp : allPersons){
            if(temp instanceof Profesor){
                Profesor tempProfesor = (Profesor)temp;
                System.out.println(temp.getName() + ": " + calculateCourseCount(tempProfesor));
            }
        } 

        System.out.println("-------------ALL STUDENTS--------------------");
        ArrayList<Student> onlyStudents = new ArrayList<>();
        for(Person temp : allPersons){
            if(temp instanceof Student){
                Student tempStudent = (Student)temp;
                System.out.println(tempStudent.getName() + ": ");
                onlyStudents.add(tempStudent);
            }
        } 

        ArrayList<Student> sortedAllStudentList = sortStudents();
        System.out.println("--------------SORTED ALL STUDENTS-------------------");
        for(Student temp : sortedAllStudentList){
            System.out.println(temp);
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

    private static int calculateCourseCount(Profesor profesor){
        if(profesor != null){
            int courseCounter = 0;

            for(Course temp : allCoursesList){
                if(temp.getProfesor().equals(profesor)){
                    courseCounter++;
                } 
            }
            return courseCounter;
        }
        else{
            return 0;
        }
    }

    private static ArrayList<Student> sortStudents(){
        ArrayList<Student> sortedStudents = new ArrayList<>();

        for(Person temp : allPersons){
            if(temp instanceof Student){
                Student tempStudent = (Student)temp;
                sortedStudents.add(tempStudent);
            }
        }

        for(int i = 0; i < sortedStudents.size(); i++){
            for(int j = 0; j < sortedStudents.size(); j++){
                float student1AVGGrade = calculateAVGGrade(sortedStudents.get(i));
                float student2AVGGrade = calculateAVGGrade(sortedStudents.get(j));

                if(student1AVGGrade > student2AVGGrade){
                    Student temp = sortedStudents.get(i);
                    sortedStudents.set(i, sortedStudents.get(j));
                    sortedStudents.set(j, temp);
                }

            }
        }

        return sortedStudents;
    }

}


