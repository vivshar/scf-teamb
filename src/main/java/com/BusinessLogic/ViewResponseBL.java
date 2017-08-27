package com.BusinessLogic;

import java.util.ArrayList;
import java.util.List;

import com.vivshar.DAO.DAOImpl;
import com.vivshar.POJO.JsonParse.viewResponse.ListOfResponses;
import com.vivshar.POJO.JsonParse.viewResponse.Response;
import com.vivshar.POJO.Table.ProposalSellersBid;

public class ViewResponseBL {

	public static ListOfResponses ViewAllResponses(Integer pid) {
		
		DAOImpl daoImpl = new DAOImpl();
		List<ProposalSellersBid> list = new ArrayList<ProposalSellersBid>();
		list =  daoImpl.get_all_responses(pid);
		ListOfResponses listOfResponses = new ListOfResponses();
		listOfResponses.setResponses(list);
		
		return listOfResponses;
	}
	public static Response viewResponse(int proposal_id, int seller_id) {
		
		Response r = new Response();
		DAOImpl daoimpl = new DAOImpl();
		r.setResponse(daoimpl.get_response(proposal_id, seller_id));
		return r;
	}

	
	
}
