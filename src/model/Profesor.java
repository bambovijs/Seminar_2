package model;

public class Profesor {
    // 1. variables
    private long p_id;
    private String p_name;
    private String p_surename;
    private Degree p_degree;
    private static long profesorCounter = 1000;

    // 2. getters and setters
    public long getP_id() {
        return p_id;
    }
    public void setP_id() {
        this.p_id = profesorCounter;
        profesorCounter++;
    }
    public String getP_name() {
        return p_name;
    }
    public void setP_name(String p_name) {
        if(p_name != null && p_name.matches("[A-ZĒŪĪĀŠĢĶĻŽČŅ]{1}[a-zēūīāšģķļžčņ]+([ ][A-ZĒŪĪĀŠĢĶĻŽČŅ]{1}[a-zēūīāšģķļžčņ]+)?")){
            this.p_name = p_name;
        }
        else {
            this.p_name = "Unknown";
        }
    }
    public String getP_surename() {
        return p_surename;
    }
    public void setP_surename(String p_surename) {
        if(p_surename != null && p_surename.matches("[A-ZĒŪĪĀŠĢĶĻŽČŅ]{1}[a-zēūīāšģķļžčņ]+([-][A-ZĒŪĪĀŠĢĶĻŽČŅ]{1}[a-zēūīāšģķļžčņ]+)?")){
            this.p_surename = p_surename;
        }
        else {
            this.p_surename = "Unknown";
        }
    }
    public Degree getP_degree() {
        return p_degree;
    }
    public void setP_degree(Degree p_degree) {
        if(p_degree != null){
            this.p_degree = p_degree;
        }
        else {
            this.p_degree = Degree.Unknown;
        }
    }

    // 3. construcotrs
    public Profesor(){
        setP_id();
        setP_name("Unknown");
        setP_surename("Unknown");
        setP_degree(Degree.Unknown);
    }

    public Profesor(String p_name, String p_surename, Degree p_degree) {
        setP_id();
        setP_name(p_name);
        setP_surename(p_surename);
        setP_degree(p_degree);
    }
    @Override
    public String toString() {
        return "Profesor [p_id=" + p_id + ", p_name=" + p_name + ", p_surename=" + p_surename + ", p_degree=" + p_degree
                + "]";
    }

    // 4. toString()

    
    // 5. additional functions 
}
