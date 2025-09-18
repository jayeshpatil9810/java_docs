package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.Entity.JournalEntry;
import net.engineeringdigest.journalApp.Entity.User;
import net.engineeringdigest.journalApp.Repository.UserRepo;
import net.engineeringdigest.journalApp.Service.JournalEntryService;
import net.engineeringdigest.journalApp.Service.UserService;
import net.engineeringdigest.journalApp.Service.WeatherService;
import net.engineeringdigest.journalApp.api_response.WeatherResposne;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


//    @PostMapping
//    public ResponseEntity<?> createUser(@RequestBody User user) {
//        userService.saveEntry(user);
//        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
//    }


    //@PutMapping("/{userName}")
    @PutMapping
    // public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String userName){
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //this line have store the username, when any user will authenticate then information will store in securityContextHolder.
        String userName = authentication.getName();
        User userInDb = userService.findByUserName(userName);
        //if(userInDb!=null){
        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userService.saveNewUser(userInDb);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserById() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //this will execute when user will authenticated.
        userRepo.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/api")
    public ResponseEntity<?> greeting() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResposne weatherResposne = weatherService.getWeather("Mumbai");
        String greeting = "";
        if (weatherResposne != null) {
            greeting = ",weather feels like" + weatherResposne.getCurrent().getFeelslike();
        }
        return new ResponseEntity<>("Hi" + authentication.getName()+ greeting, HttpStatus.OK);

    }


}



