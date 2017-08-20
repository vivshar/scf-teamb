package com.vivshar.TablePOJO;

public class FeaturesTable {

	Integer featuresId;
	Integer productsId;
	String specification;
	char priorityOrder;
	String attachment;
	public Integer getFeaturesId() {
		return featuresId;
	}
	public void setFeaturesId(Integer featuresId) {
		this.featuresId = featuresId;
	}
	public Integer getProductsId() {
		return productsId;
	}
	public void setProductsId(Integer productsId) {
		this.productsId = productsId;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public char getPriorityOrder() {
		return priorityOrder;
	}
	public void setPriorityOrder(char priorityOrder) {
		this.priorityOrder = priorityOrder;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	
	
}
