package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.conversions.Bson;

public class Main {
    public static void main( String[] args ) {
        // Creating a Mongo client
        MongoClient mongo = MongoClients.create("mongodb://localhost:27017");

        MongoDatabase database = mongo.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("datos");

        //Document doc = (Document) collection.find(new Document("title", "The Room"));
        String doc = collection.find().toString();

        if (doc == null) {
            System.out.println("No results found.");
        } else {
            System.out.println(" doc --> "+doc);
        }

    }
}