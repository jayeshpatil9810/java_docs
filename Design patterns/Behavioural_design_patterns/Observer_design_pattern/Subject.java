package Behavioural_design_patterns.Observer_design_pattern;


public interface Subject {

    void subscribe(Observer ob);
    void unsubscribe(Observer ob);

    void newVideoUploaded(String videoTitle);


    }

    



    

