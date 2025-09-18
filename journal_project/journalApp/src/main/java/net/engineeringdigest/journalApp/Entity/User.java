package net.engineeringdigest.journalApp.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@Document(collection = "users")
public class User {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    private String userName;

    private String email;
    private String sentimentAnalysis;

    private String password;

    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @DBRef
    @JsonInclude(JsonInclude.Include.ALWAYS)
    private List<JournalEntry> journalEntries = new ArrayList<>();

    public User() {
    }

}
