package model;

public class Student extends Person {
    // 1. VARIABLES
    private long id;
    private Faculty faculty;
    private static long studentCounter = 0;

    // 2. GETTERS AND SETTERS
    public long getId(){
        return id;
    }

    public void setId() {
        this.id = studentCounter;
        studentCounter++;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        if(faculty != null){
            this.faculty = faculty;
        }
        else {
            this.faculty = Faculty.Unknown;
        }
    }

    // REGEX for personal code - [0-9]{2}[0,1][0-9][0-9]-[0-9]{5}
    // TODO try to combine both patterns for personal codes
    // REGEX for new personal code pattern - 32{1}[0-9]{9}  

    // 3. CONSTRUCTORS
    // no args constructor
    public Student(){
        super();
        setId();    
        setFaculty(Faculty.Unknown);
    }
    // args constructor 
    public Student(String name, String surename, Faculty faculty, String personalCode){
        super(name, surename, personalCode);
        setId();
        setFaculty(faculty);
    }

    // 4. toString
    // Automaticly owerriten in main function @ MainService if call String function
    public String toString(){
        return "" + id + ": " + super.toString() + ", " + faculty; 
    }

    // 5. ADDITIONAL FUNCTIONS

}