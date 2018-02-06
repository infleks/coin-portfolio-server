package tr.com.coinportfolio.mongo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoConnector {

	public static void main(String[] args) {
		
		
		MongoClient mongoClient = new MongoClient( "localhost" , 27017  );
		
		MongoDatabase db = mongoClient.getDatabase("CoinPort");
		MongoCollection<Document> mc = db.getCollection("Portfollio");
		
		MongoCursor<Document> all = mc.find().iterator();
		
		while( all.hasNext()  ) {
			Document d = all.next();
			System.out.println(d);
		}
		mongoClient.close();
	}

}
