package com.vivshar.teamB;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.vivshar.POJO.Feature;
import com.vivshar.POJO.Product;
import com.vivshar.POJO.Proposal;

@Path("/create")
public class JSONService {
	
	@POST
	@Path("/proposal")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_JSON)
	public String createProposalClass(Proposal p) {
		String s=new String();
		for(Product prod : p.getProducts()) {
			System.out.println(prod.getId());
			s.concat(""+prod.getId());
			System.out.println(prod.getQuantity());
			s.concat(""+prod.getQuantity());
			System.out.println("Features:");
			s.concat("Features:");
			for(Feature f : prod.getFeatures()) {
				System.out.println(f.getSpecification());
				s.concat(f.getSpecification());
				System.out.println(f.getPriorityOrder());
				s.concat(f.getPriorityOrder());
			}
		}
		System.out.println(p.getDescription());
		s.concat(p.getDescription());
		System.out.println(p.getDeliveryTermsId());
		s.concat(""+p.getDeliveryTermsId());
		System.out.println(p.getPaymentTermsId());
		s.concat(""+p.getPaymentTermsId());
		return "<h1>"+p.getDescription()+"</h1>";
	}
	
	
}