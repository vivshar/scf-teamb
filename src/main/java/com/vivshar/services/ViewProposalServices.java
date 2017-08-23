package com.vivshar.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.BusinessLogic.ViewProposalBL;
import com.vivshar.POJO.JsonParse.viewProposal.ListOfProposals;

@Path("view")
public class ViewProposalServices {

	@Path("/proposals")
	@Produces(MediaType.APPLICATION_JSON)
	public ListOfProposals proposalList() {
		
		
		/*HttpSession ses = httpRequest.getSession(false);
    	User usr =  (User)ses.getAttribute("user");*/
		int userId = 1;
		
		
		
		return null;
		
	}
	@Path("/proposals/inactivate/{id}")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String inactivateProposal(@PathParam("id") int proposalId) {
		if(ViewProposalBL.InactivateProposal(proposalId))
			return "<p>Proposal Inactivated successfully!!!<p>";
		
		return "<p>Unable to Inactivate proposal!!<p>";
	}
	
	
}
