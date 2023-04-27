package model;

public class Profesor extends Person {
    // 1. variables
    private long p_id;
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
        super();
        setP_id();
        setP_degree(Degree.Unknown);
    }

    public Profesor(String name, String surname, String personalCode, Degree p_degree) {
        super(name, surname, personalCode);
        setP_id();
        setP_degree(p_degree);
    }
    
    // 4. toString()
    @Override
    public String toString() {
        return "" + p_id + ": " + super.toString() + ", " + p_degree + "";
    }

    
    // 5. additional functions 
}
