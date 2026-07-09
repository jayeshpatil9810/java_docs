import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Concurrent_check {
    public static void main(String[] args) {
        
        List<String> sharedList = new ArrayList<>();
        sharedList.add("item1");
        sharedList.add("item2");
        sharedList.add("item3");
        Thread readThread = new Thread(()->{
            try{
                while (true) {
                    for(String item:sharedList){
                        System.out.println("Reading item"+item);
                        Thread.sleep(100);
                    }
                    
                }
            } catch (Exception e) {
                System.out.println("exception in reader theread"+e);
            }
            });
        Thread writeThread = new Thread(()->{
            try{
                sharedList.add("item4");
                System.out.println("added item4 to the list");
                Thread.sleep(500);
                sharedList.remove("remove item1 from the list");
                System.out.println("remove item1 from the list");
            }catch(InterruptedException e){
                e.printStackTrace();
            });
            readThread.start();
            writeThread.start();
                
        }
        
    }
    
}

