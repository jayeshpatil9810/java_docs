package net.engineeringdigest.journalApp.Service;
import net.engineeringdigest.journalApp.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.regex.Pattern;

//this class we using for sentiment analysis using mongodb criteria
//because for complex queries we are using the criteria concept.
@Service
public class UserRepositoryImple {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> getUserForSA(){
        Query query = new Query();
        query.addCriteria(Criteria.where("email") .regex(Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", Pattern.CASE_INSENSITIVE)));
        query.addCriteria(Criteria.where("sentimentAnalysis").is(true)); //is means is equal to

//      query.addCriteria(Criteria.where("userName").is("vipul"));
//      query.addCriteria(Criteria.where("age").gte(20)); //gte means greater than equals
        List<User> users = mongoTemplate.find(query,User.class);
        return users;
    }


}
