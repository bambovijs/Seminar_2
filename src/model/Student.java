package model;

public class Student extends Person {
    // 1. VARIABLES
    private long id;
    private String name;
    private String surename;
    private Faculty faculty;
    private String personalCode;
    private static long studentCounter = 0;

    // 2. GETTERS AND SETTERS
    public long getId(){
        return id;
    }

    public void setId() {
        this.id = studentCounter;
        studentCounter++;
    }

    public String getName() {
        return name;
    }

    // TODO - REGEX WEB - https://regex101.com/
    // REGEX - [A-Z](1)[a-z]*
    // REGEX for two names - [A-ZĒŪĪĀŠĢĶĻŽČŅ]{1}[a-zēūīāšģķļžčņ]+[ ]?([A-ZĒŪĪĀŠĢĶĻŽČŅ]{1}[a-zēūīāšģķļžčņ]+)?
    public void setName(String name) {
        if(name != null && name.matches("[A-ZĒŪĪĀŠĢĶĻŽČŅ]{1}[a-zēūīāšģķļžčņ]+([ ][A-ZĒŪĪĀŠĢĶĻŽČŅ]{1}[a-zēūīāšģķļžčņ]+)?")){
            this.name = name;
        }
        else {
            this.name = "Unknown";
        }
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        if(surename != null && surename.matches("[A-ZĒŪĪĀŠĢĶĻŽČŅ]{1}[a-zēūīāšģķļžčņ]+([-][A-ZĒŪĪĀŠĢĶĻŽČŅ]{1}[a-zēūīāšģķļžčņ]+)?")){
            this.surename = surename;
        }
        else {
            this.surename = "Unknown";
        }
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

    public String getPersonalCode() {
        return personalCode;
    }

    // REGEX for personal code - [0-9]{2}[0,1][0-9][0-9]-[0-9]{5}
    // TODO try to combine both patterns for personal codes
    // REGEX for new personal code pattern - 32{1}[0-9]{9}  
    public void setPersonalCode(String personalCode) {
        if(personalCode != null && personalCode.matches("[0-9]{2}[0,1][0-9][0-9]-[0-9]{5}")){
            this.personalCode = personalCode;
        } 
        else {
            this.personalCode = "000000-00000";
        }
    }

    // 3. CONSTRUCTORS
    // no args constructor
    public Student(){
        setId();    
        setName("Unknown");
        setSurename("Unknown");
        setFaculty(Faculty.Unknown);
        setPersonalCode("000000-00000");
    }
    // args constructor s
    public Student(String name, String surename, Faculty faculty, String personalCode){
        setId();
        setName(name);
        setSurename(surename);
        setFaculty(faculty);
        setPersonalCode(personalCode);
    }

    // 4. toString
    // Automaticly owerriten in main function @ MainService if call String function
    public String toString(){
        return "" + id + ": " + name + ", " + surename + ", " + faculty; 
    }

    // 5. ADDITIONAL FUNCTIONS

}