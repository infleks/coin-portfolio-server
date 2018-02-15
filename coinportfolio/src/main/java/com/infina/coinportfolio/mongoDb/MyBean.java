package com.infina.coinportfolio.mongoDb;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Component;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

@Component
public class MyBean {

    private final MongoDbFactory mongo;

    @Autowired
    public MyBean(MongoDbFactory mongo) {
        this.mongo = mongo;
    }

    // ...

    public void example() {
        DB dba = mongo.getDb();
        // ...
        
		MongoClient mongoClient = new MongoClient( "localhost" , 27017  );
		
		MongoDatabase db = mongoClient.getDatabase("CoinPort");
		MongoCollection<Document> mc = db.getCollection("Portfolio");
		
		MongoCursor<Document> all = mc.find().iterator();
		
		while( all.hasNext()  ) {
			Document d = all.next();
			System.out.println(d);
		}
		mongoClient.close();
    }

}