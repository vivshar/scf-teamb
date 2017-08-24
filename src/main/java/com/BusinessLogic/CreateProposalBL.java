package com.BusinessLogic;

import com.vivshar.DAO.DAOImpl;
import com.vivshar.POJO.JsonParse.createProposal.Feature;
import com.vivshar.POJO.JsonParse.createProposal.Product;
import com.vivshar.POJO.JsonParse.createProposal.Proposal;
import com.vivshar.POJO.Table.FeaturesTable;
import com.vivshar.POJO.Table.ProductsTable;
import com.vivshar.POJO.Table.ProposalsTable;

public class CreateProposalBL {

	public static boolean create(Proposal proposal) {
		
		DAOImpl daoImpl=new DAOImpl();
		ProposalsTable proposalsTable = new ProposalsTable();
		ProductsTable productsTable = new ProductsTable();
		FeaturesTable featuresTable = new FeaturesTable();
		
		
		
		proposalsTable = ProposalTabObj(proposal);
		Integer i = daoImpl.create_proposal(proposalsTable);
		System.out.println("Proposal inserted with id ");
		System.out.println("=============================="+i);
/*		if(i.equals(-1))
			return false;
		else*/
		proposalsTable.setProposalId(i);
		for(Product p : proposal.getProducts()) {
			productsTable = ProductsTabObj(p);
			productsTable.setProposalId(proposalsTable.getProposalId());
			i = daoImpl.enter_proposal_product(productsTable);
			System.out.println("Product inserted with id ");
			System.out.println("=============================="+i);
			
/*			if(i.equals(-1))
				return false;
			else*/
			productsTable.setId(i);
			for(Feature f : p.getFeatures()) {
				featuresTable = FeaturesTabObj(f);
				featuresTable.setProductsId(p.getId());
				featuresTable.setProposalId(proposalsTable.getProposalId());
				i = daoImpl.enter_product_features(featuresTable);
				if(i == 1)
				{System.out.println("feature inserted with id ");
				System.out.println("=============================="+i);}
/*				if(i.equals(-1))
					return false;
				else*/
				featuresTable.setFeaturesId(i);
			}
		}
		
		
		
		
		return true;
		
	}
	
	private static ProposalsTable ProposalTabObj(Proposal p) {
		ProposalsTable pt =new ProposalsTable();
		pt.setBuyerId(1);
		pt.setDescription(p.getDescription());
		pt.setBuyerStatus('y');
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
		ft.setFeaturesId(f.getFid());
		ft.setPriorityOrder(f.getPriorityOrder().charAt(0));
		return ft;
	}
	
}
