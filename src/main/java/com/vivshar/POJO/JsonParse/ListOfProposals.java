package com.vivshar.POJO.JsonParse;

import java.util.ArrayList;
import java.util.List;

import com.vivshar.POJO.Table.ProposalsTable;

public class ListOfProposals {
	private List<ProposalsTable> proposals = new ArrayList<ProposalsTable>();

	public List<ProposalsTable> getProposals() {
		return proposals;
	}

	public void setProposals(List<ProposalsTable> proposals) {
		this.proposals = proposals;
	}
}
