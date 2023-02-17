
package com.deitel.welcomerestxml;

import java.io.StringWriter;
import javax.ws.rs.Produces; // annotation to specify type of data
import javax.xml.bind.JAXB; // utility class for common JABX operations
import javax.ws.rs.core.Context;
import javax.ws.rs.PathParam; // annotation to get parameters from URI
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET; // annotation to indicate method uses HTTP GET
import javax.ws.rs.Path;// annotation to specify path of resource
import javax.ws.rs.PUT;


@Path("welcome") // URI used to access the resource
public class WelcomeRESTXMLResource {

    
    // retrieve welcome message
    @GET // handles HTTP GET requests
    @Path("{name}") // URI componet containing parameters
    @Produces("application/xml")
    public String getXml(@PathParam("name") String name) { 
        String message = "Welcome to JAX-RS web services with REST and " +
                "XML, " + name + "!"; // our welcome message
        StringWriter writer = new StringWriter();
        JAXB.marshal(message, writer); // marshal String as XML
        return writer.toString(); // return XML as String
    }
}
