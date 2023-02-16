package org.example;

import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

public class ConnectToDB {

    public static void main( String args[] ) {

        // Creating a Mongo client
        MongoClient mongo = MongoClients.create("mongodb://localhost:27017");

        // Accessing the database
        MongoDatabase test = mongo.getDatabase("test");

        // Retrieving a collection
        MongoCollection<Document> collection = test.getCollection("datos");
        System.out.println("Collection sampleCollection selected successfully");

        //preparar documento para insertar
        Document document = new Document("_id", 11)
                .append("puntuacion", 10)
                .append("exame", "test")
                .append("estudiante", 77);

        //Inserting document into the collection
        collection.insertOne(document);
        System.out.println("Document inserted successfully");


    }
}
