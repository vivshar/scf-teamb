package com.BusinessLogic;

import com.vivshar.DAO.DAOImpl;
import com.vivshar.POJO.JsonParse.viewProposal.ListOfProposals;

public class ViewProposalBL {
	
	public static ListOfProposals view(Integer id) {
		
		
		
		ListOfProposals lp = new ListOfProposals();
		DAOImpl daoImpl = new DAOImpl();
		
		lp.setProposals(daoImpl.view_proposals(id));
		
		return lp;
	}
	
	public static boolean InactivateProposal(Integer proposalId) {
		DAOImpl daoImpl = new DAOImpl();
		
		return daoImpl.InactivateProposal(proposalId);
	}

}
