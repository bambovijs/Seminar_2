package model;

public class Person {
    //1.variables
    private String name;
    private String surname;
    private String personalCode;

    //2.Getters and setters
    public String getName(){
        return name;
    }

    public void setName(String name) {
        if(name != null && name.matches("[A-ZĒŪĪĀŠĢĶĻŽČŅ]{1}[a-zēūīāšģķļžčņ]+([ ][A-ZĒŪĪĀŠĢĶĻŽČŅ]{1}[a-zēūīāšģķļžčņ]+)?")){
            this.name = name;
        }
        else {
            this.name = "Unknown";
        }
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname) {
        if(surname != null && surname.matches("[A-ZĒŪĪĀŠĢĶĻŽČŅ]{1}[a-zēūīāšģķļžčņ]+([ ][A-ZĒŪĪĀŠĢĶĻŽČŅ]{1}[a-zēūīāšģķļžčņ]+)?")){
            this.surname = surname;
        }
        else {
            this.surname = "Unknown";
        }
    }

    public String getPersonalCode(){
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        if(personalCode != null && personalCode.matches("[0-9]{2}[0,1][0-9][0-9]-[0-9]{5}")){
            this.personalCode = personalCode;
        } 
        else {
            this.personalCode = "000000-00000";
        }
    }

    //3.Constructors
    public Person(){
        setName("Unknown");
        setSurname("Unknown");
        setPersonalCode("000000-00000");
    }

    public Person(String name, String surname, String personalCode) {
        setName(name);
        setSurname(surname);
        setPersonalCode(personalCode);
    }

    //4.toString 
    @Override
    public String toString() {
        return "" + name + ", " + surname + ", " + personalCode + "  ";
    }

    //5.Aditional functions
}
