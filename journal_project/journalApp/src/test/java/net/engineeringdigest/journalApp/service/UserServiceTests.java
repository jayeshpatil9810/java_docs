//package net.engineeringdigest.journalApp.service;
//
//import lombok.Builder;
//import net.engineeringdigest.journalApp.Repository.UserRepo;
//import net.engineeringdigest.journalApp.Service.UserService;
//import org.junit.Assert;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class UserServiceTests {
//
//    @Autowired
//    private UserRepo userRepo;
//
//    @Autowired
//    private UserService userService;
//
//    @BeforeEach   //before each test this function will execute this is the use of beforeeac annotation.
//    void setUp(){
//
//    }
//
//
//
//
//    @ParameterizedTest
//    @ValueSource(strings = {
//            "ram",
//            "shyam",
//            "vipul"
//    })
//    public void testFindByUserName(String name){
//        //Assert.assertEquals(4,2+1);
//        Assert.assertNotNull(userRepo.findByUserName(name));
//
//    }
//
//    @ParameterizedTest
//    @CsvSource({
//            "1,1,2",
//            "2,10,12",
//            "3,3,9"
//    })
//    public void test(int a,int b,int expected){
//        Assert.assertEquals(expected,a+b);
//    }
//}
