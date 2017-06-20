package com.company.dataanalysis.model.dao;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.company.dataanalysis.model.dto.FinancialsDetail;
import com.company.dataanalysis.model.dto.FinancialsDetailSummaryByDescription;

public class FinancialsSummaryToReadByDescription {
	
	public ArrayList<FinancialsDetailSummaryByDescription> summaryByDescription() throws FileNotFoundException, InterruptedException {
		
		//Read csv file
		ArrayList<FinancialsDetail> data = new FinancialsToRead().readData();
		
		//Find unique type values
		ArrayList<String> type = new ArrayList<String>();
		for(FinancialsDetail fd : data) {
			if(!type.contains(fd.getType())) {
				type.add(fd.getType());
			}
		}
		
		//Find unique description
		ArrayList<String> desc = new ArrayList<String>();
		for(FinancialsDetail fd : data) {
			if(!desc.contains(fd.getDescription())) {
				desc.add(fd.getDescription());
			}
		}
			
		//Calculate Total amount by unique description
		ArrayList<FinancialsDetailSummaryByDescription> descriptionSummary = new ArrayList<FinancialsDetailSummaryByDescription>(); 
		Double amountDescription = 0.0;
		for(String tp : type) {
			for(String ds : desc) {
					FinancialsDetailSummaryByDescription description = new FinancialsDetailSummaryByDescription();
					for(FinancialsDetail fd : data) {
						if(fd.getDescription().equals(ds) && fd.getType().equals(tp)) {
							amountDescription += fd.getAmount();			
						}
					}
					description.setDescription(ds);
					description.setAmount(amountDescription);
					description.setType(tp);
					descriptionSummary.add(description);
					amountDescription = 0.0;
				}
			
		}
		return descriptionSummary;
	}
	
	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		FinancialsSummaryToReadByDescription prova = new FinancialsSummaryToReadByDescription();
		ArrayList<FinancialsDetailSummaryByDescription> prova2 = prova.summaryByDescription();
		for(FinancialsDetailSummaryByDescription i : prova2) {
			if(i.getAmount()>0) {
				System.out.println(i);
			}
		}
	}

}
