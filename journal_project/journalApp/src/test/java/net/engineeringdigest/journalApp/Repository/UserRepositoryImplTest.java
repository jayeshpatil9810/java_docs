package net.engineeringdigest.journalApp.Repository;

import net.engineeringdigest.journalApp.Service.UserRepositoryImple;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryImplTest {

    @Autowired
    private UserRepositoryImple userRepositoryImple;

    @Test
    public void testSaveNewUser(){
        userRepositoryImple.getUserForSA();

    }
}
