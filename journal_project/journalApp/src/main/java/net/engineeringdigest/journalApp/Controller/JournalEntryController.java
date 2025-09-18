//package net.engineeringdigest.journalApp.Controller;
//
//import net.engineeringdigest.journalApp.Entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/_journal")
//public class JournalEntryController {
//
//    private Map<Long,JournalEntry> journalEntries = new HashMap<>();
//
//    @GetMapping
//    public List<JournalEntry> getAll(){
//        return new ArrayList<>(journalEntries.values());
//    }
//
//    @PostMapping
//    public JournalEntry createEntry(@RequestBody JournalEntry journalEntry){
//        journalEntries.put(journalEntry.getId(),journalEntry);
//        return true;
//
//    }
//
//    @GetMapping("id/{myId}")
//    public JournalEntry getEntryById(@PathVariable Long myId){
//        return journalEntries.get(myId);
//    }
//
//    @DeleteMapping("id/{myId}")
//    public JournalEntry deleteJournalEntryById(@PathVariable Long myId){
//        return journalEntries.remove(myId);
//
//
//    }
//    @PutMapping("/id/{id}")
//    public JournalEntry updateJounalById(@PathVariable Long id,@RequestBody JournalEntry myEntry){
//        return journalEntries.put(id,myEntry);
//    }
//
//
//}
