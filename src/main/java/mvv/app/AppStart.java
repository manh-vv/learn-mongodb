package mvv.app;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import mvv.app.model.Person;
import mvv.app.utils.GenerateModel;
import mvv.app.utils.JsonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manh.vu on 6/4/2015.
 */
public class AppStart {
    private static final Logger log = LogManager.getLogger(AppStart.class);

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;

    private GenerateModel generateModel = new GenerateModel();

    public static void main(String[] args) {
        log.info("App start");

        AppStart app = new AppStart();
        
        // connect to mongo
        app.mongoClient = new MongoClient("127.0.0.1", 27017);
        app.mongoDatabase = app.mongoClient.getDatabase("local");

        // insert into mongo db
        app.insertPerson();

        app.mongoClient.close();
        log.info("App stop");
    }

    private void insertPerson() {
        MongoCollection<Document> collection = mongoDatabase.getCollection("person");

        List<Person> personList = generateModel.listPerson();
        List<Document> documentList = new ArrayList<>(personList.size());

        personList.forEach(p -> {
            Document d = Document.parse(JsonUtils.objectToJson(p));
            documentList.add(d);
        });

        collection.insertMany(documentList);
    }
}
