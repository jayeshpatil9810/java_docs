package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.Entity.JournalEntry;
import net.engineeringdigest.journalApp.Entity.User;
import net.engineeringdigest.journalApp.Service.JournalEntryService;
import net.engineeringdigest.journalApp.Service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.JobHoldUntil;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private final JournalEntryService journalEntryService;

    public JournalEntryControllerV2(JournalEntryService journalEntryService) {
        this.journalEntryService = journalEntryService;
    }

    @Autowired
    private UserService userService;

        //@GetMapping("{userName}")
        //public ResponseEntity<?> getAllJounalEntriesOfUser(@PathVariable String userName) {
        @GetMapping()
        public ResponseEntity<?> getAllJounalEntriesOfUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); //this line have store the username, when any user will authenticate then information will store in securityContextHolder.
        String userName = authentication.getName();
        User user1= userService.findByUserName(userName);
        List<JournalEntry> all=user1.getJournalEntries();
        if(all!=null && !all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //@PostMapping("{userName}")
    //public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry journalEntry, @PathVariable String userName) {
       @PostMapping
       public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry journalEntry){ //I remove pathvariable because username will come using securitycontextholder
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String userName = authentication.getName();
            journalEntry.setDate(LocalDateTime.now());
            journalEntryService.saveEntry(journalEntry,userName);
            return new ResponseEntity<>(journalEntry,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getEntryById(@PathVariable ObjectId myId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByUserName(userName);
        List<JournalEntry> collect = user.getJournalEntries().stream().filter(x -> x.getId().equals(myId)).collect(Collectors.toList());
        if (!collect.isEmpty()) {
            Optional<JournalEntry> journalEntry = journalEntryService.findByID(myId);
            if (journalEntry.isPresent()) {
                return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
            }
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    //@DeleteMapping("id/{userName}/{myId}")
    //public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId,@PathVariable String userName){
    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        boolean removed = journalEntryService.deleteById(myId,userName);
        if(removed) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//    @PutMapping("/id/{userName}/{myId}")
//    public JournalEntry updateJounalById(@PathVariable ObjectId myId,@RequestBody JournalEntry newEntry, @PathVariable String userName){String
      @PutMapping("id/{myId}")
      public ResponseEntity<?> updateJounalById(@PathVariable ObjectId myId,@RequestBody JournalEntry newEntry){
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      String username=authentication.getName();
      User user = userService.findByUserName(username);
      List<JournalEntry> collect = user.getJournalEntries().stream().filter(x->x.getId().equals(myId)).collect(Collectors.toList());
      if(!collect.isEmpty()) {
          Optional<JournalEntry> journalEntry1 = journalEntryService.findByID(myId);
          if (journalEntry1.isPresent()) {
              JournalEntry old = journalEntry1.get();
              old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
              old.setContent(newEntry.getContent() != null && newEntry.equals("") ? newEntry.getContent() : old.getContent());
              journalEntryService.saveEntry(old);
              return new ResponseEntity<>(old, HttpStatus.OK);
           }
      }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    }