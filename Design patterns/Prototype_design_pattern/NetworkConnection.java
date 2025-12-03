package Prototype_design_pattern;

import java.util.ArrayList;
import java.util.List;

public class NetworkConnection implements Cloneable {

    private String ip;
    private String importantData;

    //domains is reference variable of List type(created for understand the deep copy)
    //matlab ab network connection ke andar domains dusra object he 
    private List<String> domains= new ArrayList<>();


    
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getImportantData() {
        return importantData;
    }
    public void setImportantData(String importantData) {
        this.importantData = importantData;
    }
    
    public void loadVeryImportantData()throws InterruptedException{
        this.importantData = "data connection important data";
        domains.add("www.jayeshlearnings.com");
        domains.add("wwww.technologies.com");
        domains.add("lcwd.com");
        Thread.sleep(5000);
    }
 
    @Override
    public String toString() {
        return "NetworkConnection [ip=" + ip + ", importantData=" + importantData + ", domains=" + domains + "]";
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //logic for deep cloning
        NetworkConnection networkConnection = new NetworkConnection();
        networkConnection.setIp(this.getIp());
        networkConnection.setImportantData(this.getImportantData());
        for(String d:this.getDomains()){
            networkConnection.getDomains().add(d);
        }
        return networkConnection;
    }
    
    public List<String> getDomains() {
        return domains;
    }
    public void setDomains(List<String> domains) {
        this.domains = domains;
    }
    
    
}
