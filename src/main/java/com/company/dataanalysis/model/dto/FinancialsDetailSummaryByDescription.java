package com.company.dataanalysis.model.dto;

public class FinancialsDetailSummaryByDescription {
	
	private String description;
	private Double amount;
	private String type;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return description + " " + amount + " " + type;
	}

}
