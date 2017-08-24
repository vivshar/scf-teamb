package com.BusinessLogic;

import com.vivshar.POJO.JsonParse.viewProposal.SelectedProposal;

public class UpdateProposalBL {

	
	public static SelectedProposal UpdateProposalView(Integer proposalId) {
		return ViewProposalBL.GetProposalWithId(proposalId);
	}
	
	public static boolean UpdateProposal(SelectedProposal selectedProposal) {
		
		
		
		return false;
	}
	
}
