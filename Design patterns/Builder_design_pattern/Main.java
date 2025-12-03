package Builder_design_pattern;

public class Main {
    public static void main(String[] args) {
        
       User user =  new User.UserBuilder()
            .setEmailId("jayeshpatil1098@gmail.com")
            .setUserId("123")
            .setUserName("jayesh patil")
            .build();

        System.out.println(user);

    }
    
}
