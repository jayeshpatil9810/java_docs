package structural_design_pattern.adapter_design_pattern;

public class Demo {
    public static void main(String[] args) {
        
        System.out.println("program started...");
        AppleCharger charger=new AdapterCharger(new DkCharger());


        Iphone13 Iphone13 = new Iphone13(charger);
        Iphone13.chargeIphone();

    }
    
}
