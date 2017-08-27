package com.BusinessLogic;

import com.vivshar.DAO.DAOImpl;
import com.vivshar.POJO.JsonParse.PublishProposal.IdentifiedSellers;

public class PublishProposalBL {


	public IdentifiedSellers GetListOfSellers(Integer proposalId) {
		
		DAOImpl daoImpl = new DAOImpl();
		IdentifiedSellers identifiedSellers = new IdentifiedSellers();
		identifiedSellers.setSellers(daoImpl.ListSellers(proposalId));  
		return identifiedSellers;
	}

	public void PublishToSellers(IdentifiedSellers identifiedSellers, Integer proposalId) {
		
		DAOImpl daoImpl = new DAOImpl();
		daoImpl.PublishProposal(identifiedSellers,proposalId);
		
		
	}
	
}
