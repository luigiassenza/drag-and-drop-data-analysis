package com.company.dataanalysis.model.dto;

public class FinancialsDetailSummaryByType {
	
	private String type;
	private Double amount;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public String toString() {
		return type + ": " + amount;
	}

}
