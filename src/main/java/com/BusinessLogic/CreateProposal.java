package com.BusinessLogic;

import com.vivshar.DAO.DAOImpl;
import com.vivshar.JsonParsePOJO.Feature;
import com.vivshar.JsonParsePOJO.Product;
import com.vivshar.JsonParsePOJO.Proposal;
import com.vivshar.TablePOJO.FeaturesTable;
import com.vivshar.TablePOJO.ProductsTable;
import com.vivshar.TablePOJO.ProposalsTable;

public class CreateProposal {

	public static boolean create(Proposal proposal) {
		
		DAOImpl daoImpl=new DAOImpl();
		ProposalsTable proposalsTable = new ProposalsTable();
		ProductsTable productsTable = new ProductsTable();
		FeaturesTable featuresTable = new FeaturesTable();
		
		
		
		proposalsTable = ProposalTabObj(proposal);
		//proposalsTable.setProposalId(daoImpl.create_proposal(proposalsTable));
		for(Product p : proposal.getProducts()) {
			productsTable = ProductsTabObj(p);
			productsTable.setProposalId(proposalsTable.getProposalId());
			//productsTable.setId(daoImpl.enter_proposal_product(productsTable));
			for(Feature f : p.getFeatures()) {
				featuresTable = FeaturesTabObj(f);
				featuresTable.setProductsId(p.getId());
				//featuresTable.setFeaturesId(daoImpl.);
			}
		}
		
		
		
		
		return true;
		
	}
	
	private static ProposalsTable ProposalTabObj(Proposal p) {
		ProposalsTable pt =new ProposalsTable();
		//pt.setBuyerId(buyerId);
		pt.setDescription(p.getDescription());
		//pt.setBuyerStatus();
		pt.setpTermsId(p.getPaymentTermsId());
		pt.setdTermsId(p.getDeliveryTermsId());
		return pt;
	}
	private static ProductsTable ProductsTabObj(Product p) {
		ProductsTable pt =new ProductsTable();
		pt.setProductId(p.getId());
		pt.setQuantity(p.getQuantity());
		return pt;
	}
	private static FeaturesTable FeaturesTabObj(Feature f) {
		FeaturesTable ft =new FeaturesTable();
		ft.setSpecification(f.getSpecification());
		ft.setPriorityOrder(f.getPriorityOrder().charAt(0));
		return ft;
	}
	
}
