public class EmployeeFactory {

    public static Employee getEmployee(String EmpType){
        if(EmpType.trim().equalsIgnoreCase("ANDROID DEVELOPER")){
            return new AndroidDeveloper();
        }
        else if (EmpType.trim().equalsIgnoreCase("WEB DEVELOPER")) {
            return new WebDeveloper();
            
        }else{
            return null;
        }
    }
    
}
    