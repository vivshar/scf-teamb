package com.vivshar.teamB;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.vivshar.POJO.JsonParse.ListOfProposals;

@Path("view")
public class ViewProposal {

	@Path("/proposals")
	@Produces(MediaType.APPLICATION_JSON)
	public ListOfProposals proposalList() {
		
		
		/*HttpSession ses = httpRequest.getSession(false);
    	User usr =  (User)ses.getAttribute("user");*/
		int userId = 1;
		
		
		
		return null;
		
	}
	
	
}
