package com.BusinessLogic;

import java.util.ArrayList;
import java.util.List;

import com.vivshar.DAO.DAOImpl;
import com.vivshar.POJO.JsonParse.PublishProposal.IdentifiedSellers;

public class PublishProposalBL {


	public IdentifiedSellers GetListOfSellers(Integer proposalId) {
		System.out.println("getlistofsellers");
		DAOImpl daoImpl = new DAOImpl();
		IdentifiedSellers identifiedSellers = new IdentifiedSellers();
		List<String> l = new ArrayList<String>();
		System.out.println(proposalId);
		l = daoImpl.ListSellers(proposalId);
		System.out.println(l);

		identifiedSellers.setSellers(l);  
		return identifiedSellers;
	}

	public void PublishToSellers(IdentifiedSellers identifiedSellers, Integer proposalId) {
		
		DAOImpl daoImpl = new DAOImpl();
		daoImpl.PublishProposal(identifiedSellers,proposalId);
		
		
	}
	
}
