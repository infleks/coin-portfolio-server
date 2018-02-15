package com.infina.coinportfolio.coinportfolio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infina.coinportfolio.mongoDb.MyBean;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

@RestController
public class PortfolioRestController {

	
    @RequestMapping("/portfolioInfo")
    public List<Portfolio> greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	//MongoDbFactory factory = new Mongod
    	//MyBean bean = new MyBean(mongo)
    	
    	
    	return getPortfolioList();
//        return new Portfolio("umut", BigDecimal.ONE);
    }
    
    
    private List<Portfolio> getPortfolioList(){
    	List<Portfolio> result = new ArrayList<>();
		MongoClient mongoClient = new MongoClient( "localhost" , 27017  );
		
		MongoDatabase db = mongoClient.getDatabase("CoinPort");	
		MongoCollection<Document> mc = db.getCollection("Portfolio");
		
		MongoCursor<Document> all = mc.find().iterator();
		
		while( all.hasNext()  ) {
			Document d = all.next();
			result.add( new Portfolio(d.getString("name"), BigDecimal.ONE, d.getInteger("portfolioId")));

			System.out.println(d);
		}
		mongoClient.close();
		return result;
    }
}