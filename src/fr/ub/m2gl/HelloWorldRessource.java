package fr.ub.m2gl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

@Path("hello")
public class HelloWorldRessource extends Application {
	
    @GET
    @Produces("text/plain")
    public String getHelloWorld() {
        return "Hello World from text/plain";
    }
}
