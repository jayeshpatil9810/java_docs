package Behavioural_design_patterns.Observer_design_pattern;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Subject{

    List<Observer> subscribers=new ArrayList<>();

    @Override
    public void subscribe(Observer ob) {
         this.subscribers.add(ob);
    }

    @Override
    public void unsubscribe(Observer ob) {
        this.subscribers.remove(ob);
    }

@Override
public void newVideoUploaded(String videoTitle) {
    for (Observer ob : this.subscribers) {
        ob.notified(videoTitle);  // also pass title to observers if needed
    }
}


  

    
}
