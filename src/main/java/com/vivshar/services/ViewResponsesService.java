package com.vivshar.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.BusinessLogic.ViewResponseBL;
import com.vivshar.POJO.JsonParse.viewResponse.Response;
import com.vivshar.POJO.JsonParse.viewResponse.ListOfResponses;

@Path("view")
public class ViewResponsesService {
	
	
	@Path("/all/responses/{pid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ListOfResponses ViewAllResponses(@PathParam("pid") Integer pId) {
		return ViewResponseBL.ViewAllResponses(pId);
	}
	@Path("/response/{pid}/{sid}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response ViewResponse(@PathParam("pid") Integer pid, @PathParam("sid") Integer sid) {	
		return ViewResponseBL.viewResponse(pid, sid);
		
	}
}
