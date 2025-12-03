package Behavioural_design_patterns.Observer_design_pattern;


public class Subscriber implements Observer {

    String name;
    Subscriber(String name){
        this.name=name;
    }


@Override
public void notified(String videoTitle) {
    
     System.out.println("hello" + this.name + " new video uploaded notification");
}

    
}
