package com.vivshar.POJO.JsonParse.staticDetails;

import java.util.List;
import com.vivshar.POJO.Table.PaymentTermsTable;

public class PaymentTerms {

	private List<PaymentTermsTable> payment_terms = null;

	public List<PaymentTermsTable> getPayment_terms() {
		return payment_terms;
	}

	public void setPayment_terms(List<PaymentTermsTable> payment_terms) {
		this.payment_terms = payment_terms;
	}
	
}
