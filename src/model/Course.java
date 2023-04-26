package model;

public class Course {
    //1.Variables
    private long id;
    private String title; // Only letters, digits and space
    private int creditPoints; // min = 1, max = 20
    private CourseGradeType type; // not null
    private Profesor profesor; // not null

    private static long courseCounter = 10;

    //2.Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(){
        this.id = courseCounter;
        courseCounter++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        if(title != null && title.matches("[A-ZĒŪĪĀŠĢĶĻŽČŅ]{1}[a-zēūīāšģķļžčņ0-9\s ]+")){
            this.title = title;
        }
        else {
            this.title = "Unknown Course";
        }
    }

    public int getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(int creditPoints) {
        if(creditPoints > 0 && creditPoints < 21){
            this.creditPoints = creditPoints;
        }
        else {
            this.creditPoints = 0;
        }
    }

    public CourseGradeType getType() {
        return type;
    }

    public void setCourseGradeType(CourseGradeType type){
        if(type != null){
            this.type = type;
        }
        else {
            this.type = CourseGradeType.Other;
        }
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor){
        if(profesor != null){
            this.profesor = profesor;
        }
        else {
            this.profesor = new Profesor(); // it will call Profesor constroctor without args
        }
    }

    public static long getCourseCounter() {
        return courseCounter;
    }
    
    //3.Constructors
    public Course(){
        setId();
        setTitle("Unknown Title");
        setCreditPoints(0);
        setCourseGradeType(CourseGradeType.Other);
        setProfesor(new Profesor());
    }

    public Course(String title, int creditPoints, CourseGradeType type, Profesor profesor){
        setId();
        setTitle(title);
        setCreditPoints(creditPoints);
        setCourseGradeType(type);
        setProfesor(profesor);
    }

    @Override
    public String toString() {
        return "" + id + ": " + title + ", (" + creditPoints + "), " + type
                + ", " + profesor.getP_name() + " " + profesor.getP_surename();
    }

    //4.toString
    
    //5.Additional functions
}
