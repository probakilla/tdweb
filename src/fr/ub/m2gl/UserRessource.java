package fr.ub.m2gl;

import fr.ub.m2gl.User;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.bson.Document;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


@Path("/register")
public class UserRessource {
	
	@POST
	@Produces("text/html")
	public String post (@FormParam("firstname") String firstName, 
						@FormParam("lastname") String lastName) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		
	    MongoClientURI connectionString = new MongoClientURI("mongodb://jacky:mdp1234@ds063870.mlab.com:63870/progweb");
	    MongoClient client = new MongoClient(connectionString);
		try {
		    MongoDatabase db = client.getDatabase("progweb");
		    MongoCollection<Document> collection = db.getCollection("users");
		    ObjectMapper mapper = new ObjectMapper ();
		    String jsonString = mapper.writeValueAsString(user);
		    Document doc = Document.parse(jsonString);
		    collection.insertOne(doc);
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    client.close();
		}
		return "<h1>The user : " + firstName + " " + lastName + " Successfully added !!</h1>";
	}
}

{ "_id" : { "$oid" : "5bd1c36a7abfc06845b97724" }, "FirstName" : "Pascal", "LastName" : "Lacascade" }{ "_id" : { "$oid" : "5bd1c5f47abfc06845bf01d9" }, "FirstName" : "Pascal", "LastName" : "Mongo" }{ "_id" : { "$oid" : "5bd2adc26134081aa73cf176" }, "FirstName" : "Jacky", "LastName" : "Laffrite" }{ "_id" : { "$oid" : "5bd2b5d36134081aa7ab5dc0" }, "FirstName" : "Patrique", "LastName" : "Bruel" }{ "_id" : { "$oid" : "5bd2c6246134081aa70c3c81" }, "id" : "", "LastName" : "Lacascade", "FirstName" : "Pascal" }{ "_id" : { "$oid" : "5bd2c6356134081aa70c3c83" }, "id" : "", "LastName" : "Lamouche", "FirstName" : "Teuby" }