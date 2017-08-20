package com.vivshar.teamB;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.vivshar.JsonParsePOJO.Feature;
import com.vivshar.JsonParsePOJO.Product;
import com.vivshar.JsonParsePOJO.Proposal;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("create")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET @Path("/1")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Hello, Heroku!";
    }
    @POST
	@Path("/proposal")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Proposal createProposalClass(Proposal p) {
		
		return p;
	}
}
