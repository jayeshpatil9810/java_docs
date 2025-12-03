package Builder_design_pattern;

public class User {

    private String userId;
    private String userName;
    private String emailId;

    

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", emailId=" + emailId + "]";
    }

    private User(UserBuilder builder){
        //initialize all the fields from the builder object
        this.userId=builder.userId;
        this.userName=builder.userName;
        this.emailId=builder.emailId;

    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailId() {
        return emailId;
    }
    




    //inner class to create the object
    static class UserBuilder{
            private String userId;
            private String userName;
            private String emailId;

            public UserBuilder(){

            }

            public UserBuilder setUserId(String userId) {
                this.userId = userId;
                return this;
            }

            public UserBuilder setUserName(String userName) {
                this.userName = userName;
                return this;
            }

            public UserBuilder setEmailId(String emailId) {
                this.emailId = emailId;
                return this;
            }

            public User build(){
                User user = new User(this);
                return user;
            }

          

            

    }

    }
    
    
