package com.vivshar.POJO.JsonParse.viewResponse;

import java.util.ArrayList;
import java.util.List;
import com.vivshar.POJO.Table.ProposalSellersBid;

public class ListOfResponses {

	private List<ProposalSellersBid> responses = new ArrayList<ProposalSellersBid>();

	public List<ProposalSellersBid> getResponses() {
		return responses;
	}

	public void setResponses(List<ProposalSellersBid> responses) {
		this.responses = responses;
	}
	
}
