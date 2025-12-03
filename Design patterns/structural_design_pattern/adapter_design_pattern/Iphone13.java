package structural_design_pattern.adapter_design_pattern;

public class Iphone13 {

    private AppleCharger appleCharger;

    

    public Iphone13(AppleCharger appleCharger) {
        this.appleCharger = appleCharger;
    }



    public void chargeIphone(){
        appleCharger.chargePhone();
    }
    
}
