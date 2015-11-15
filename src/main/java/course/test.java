package course;

import com.mongodb.Cursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by sevag on 29/10/2015.
 */
public class test {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost"));
        MongoDatabase db = mongoClient.getDatabase("school");
        MongoCursor<Document> colStud = db.getCollection("students");

        Cursor cur = (Cursor) colStud.find();
        try {
            while(cur.hasNext()) {
                System.out.println(cur.next());
            }
        } finally {
            cur.close();
        }
    }
}
