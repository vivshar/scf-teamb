package com.vivshar.teamB;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("view")
public class ViewProposal {

	@Path("/proposal/searchByStatus")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String searchByStatus() {
		return  "<h1>Returning search by status</h1>";
	}
	
	
}
