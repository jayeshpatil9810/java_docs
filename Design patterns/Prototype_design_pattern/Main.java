    package Prototype_design_pattern;

    public class Main {

        public static void main(String[] args)throws InterruptedException {
            
            System.out.println("creating object prototype ");

            NetworkConnection networkConnection = new NetworkConnection();
            networkConnection.setIp("192.18.90");
            networkConnection.loadVeryImportantData();
            System.out.println(networkConnection);


        //we want new object of network connection   
        try {
            NetworkConnection networkConnection2 =(NetworkConnection) networkConnection.clone();
            System.out.println(networkConnection2);
            
            networkConnection.getDomains().remove(0); //now we are doing changes on networkconnection but it will also effect on networkconncection2 becuase this is the clone object.networkconnection2 is clone object from networkconnection.(this is the shallow copy)
            System.out.println(networkConnection);
            


        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        
        }
    }
