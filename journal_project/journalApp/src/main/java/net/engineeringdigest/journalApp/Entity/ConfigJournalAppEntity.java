package net.engineeringdigest.journalApp.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@Document(collection = "config_journal_app")
public class ConfigJournalAppEntity {
    @Id
    private ObjectId id;

    @Field("Key")
    private String Key;

    @Field("Value")
    private String Value;
}