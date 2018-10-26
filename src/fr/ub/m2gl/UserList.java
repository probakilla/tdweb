package fr.ub.m2gl;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.bson.Document;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

@Path("/users")
public class UserList {
	
	@GET
	@Produces("application/json")
	public String displayUsers () {
	    MongoClientURI connectionString = new MongoClientURI("mongodb://jacky:mdp1234@ds063870.mlab.com:63870/progweb");
	    MongoClient client = new MongoClient(connectionString);
	    StringBuffer res = new StringBuffer("");
	    try {
	    	ObjectMapper mapper = new ObjectMapper();
	    	MongoDatabase db = client.getDatabase("progweb");
	    	MongoCollection<Document> collection = db.getCollection("users");
	    	FindIterable<Document> iter = collection.find();
	    	MongoCursor<Document> i = iter.iterator();
	    	User user;
	    	Map map;
	    	int cpt = 1;
	    	while (i.hasNext()) {
	    		DBObject obj = i.next();
	    		
	    		//user = mapper.readValue(str, User.class);
	    		//res.append("User No" + cpt + " : " + user.toString() + "\n");
	    		res.append(str);
	    	}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } finally {
	    	client.close();
	    }
	    return res.toString();
	}
}
