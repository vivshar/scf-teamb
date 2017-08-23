package com.BusinessLogic;

import com.vivshar.DAO.DAOImpl;
import com.vivshar.POJO.JsonParse.ListOfProposals;

public class ViewProposalBL {
	
	public static ListOfProposals view(int id) {
		
		
		
		ListOfProposals lp = new ListOfProposals();
		DAOImpl daoImpl = new DAOImpl();
		
		lp.setProposals(daoImpl.view_proposals(id));
		
		return lp;
	}

}
