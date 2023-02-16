package org.example;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class UpdateDB {
    public static void main( String args[] ) {

        // Creating a Mongo client
        MongoClient mongo = MongoClients.create("mongodb://localhost:27017");

        // Accessing the database
        MongoDatabase test = mongo.getDatabase("test");

        // Retrieving a collection
        MongoCollection<Document> collection = test.getCollection("datos");
        System.out.println("Collection sampleCollection selected successfully");

        // filtrar el update --> incrementar en 2 la puntuacion del exament tipo test de el estudiante 40
        BasicDBObject condicion = new BasicDBObject();
        condicion.put("exame","test");
        condicion.put("estudiante","40");

        BasicDBObject modificacion = new BasicDBObject().append("$inc",new BasicDBObject("puntuacion",2));


        //Inserting document into the collection
        collection.updateMany(condicion,modificacion);
        System.out.println("Document inserted successfully");


    }
}
