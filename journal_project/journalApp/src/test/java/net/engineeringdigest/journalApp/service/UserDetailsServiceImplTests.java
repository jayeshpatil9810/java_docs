package net.engineeringdigest.journalApp.service;


import net.engineeringdigest.journalApp.Entity.User;
import net.engineeringdigest.journalApp.Repository.UserRepo;
import net.engineeringdigest.journalApp.Service.UserDetailsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoPostProcessor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;

import static org.mockito.Mockito.when;

//this class is created for mock testing
@ActiveProfiles("dev") //this annotation is for this file is consider dev application yaml file.
public class UserDetailsServiceImplTests {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Mock
    private UserRepo userRepo; //this mock is use for dummy data we can use no it will fetch from database this is called mock testing

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this); //this means we are talking about this class and activate all mocks for this class and also inject that means userService will automatically inject.
    }

    @Test
    void loadUserByUsernameTest() {
        when(userRepo.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("ram").password("fkndnd").roles(new ArrayList<>()).build());
        UserDetails user = userDetailsService.loadUserByUsername("ram");
        Assertions.assertNotNull(user);

    }

}