package abstract_design_pattern;

public class WebDeveloper implements Employee{

    public int salary(){
        return 4000;
    }

    public String name(){
        System.out.println("i am web developer");
        return "rahul patil";   
    }
}
