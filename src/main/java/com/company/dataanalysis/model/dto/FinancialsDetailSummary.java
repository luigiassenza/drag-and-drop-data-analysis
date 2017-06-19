package com.company.dataanalysis.model.dto;

public class FinancialsDetailSummary {
	
	private Double amount;
	private String description;
	private String operation;
	private String type;
	private String currency;
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String toString() {
		return "Amount: " + amount + " Description: " + description + " Operation: " + operation + 
				" Type: " + type + " Currency: " + currency;	}

}
