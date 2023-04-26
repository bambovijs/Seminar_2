package model;

public class Grade {
    //1.variables
    private long g_id;
    private int gradeValue;
    private Student student;
    private Course course;

    private static long gradeCounter = 15000;

    //2.getters and setters
    public long getG_id() {
        return g_ID;
    }

    public void setG_id(){
        this.g_ID = gradeCounter;
        gradeCounter++;
    }
    public int getGradeValue() {
        return gradeValue;
    }
    public void setGradeValue(int gradeValue){
        if(gradeValue > 0 && gradeValue < 11){
            this.gradeValue = gradeValue;
        }
        else {
            this.gradeValue = 0;
        }
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student){
        if(student != null){
            this.student = student;
        }
        else {
            this.student = new Student();
        }
    }
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course){
        if(course != null){
            this.course = course;
        }
        else {
            this.course = new Course();
        }
    }
    

    //3.constructors
    public Grade(){
        setG_id();
        setCourse(new Course());
        setStudent(new Student());
        setGradeValue(0);
    }

    public Grade(int gradeValue, Student student, Course course){
        setG_id();
        setGradeValue(gradeValue);
        setStudent(student);
        setCourse(course);
    }

    //4.toString

    //aditional functions
}
