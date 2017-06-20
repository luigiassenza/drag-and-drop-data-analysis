package com.company.dataanalysis.model.dao;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.company.dataanalysis.model.dto.FinancialsDetail;
import com.company.dataanalysis.model.dto.FinancialsDetailSummaryByType;

	public class FinancialsSummaryToReadByType {
		
		public ArrayList<FinancialsDetailSummaryByType> summaryByType() throws FileNotFoundException, InterruptedException {
			 
			//Read csv file
			ArrayList<FinancialsDetail> data = new FinancialsToRead().readData();
			
			//Find unique type values
			ArrayList<String> type = new ArrayList<String>();
			for(FinancialsDetail fd : data) {
				if(!type.contains(fd.getType())) {
					type.add(fd.getType());
				}
			}
			
			//Calculate total amount per type value
			ArrayList<FinancialsDetailSummaryByType> typeSummary = new ArrayList<FinancialsDetailSummaryByType>();
			Double amountType = 0.0;
			for(String tp : type) {
				FinancialsDetailSummaryByType typeSingle = new FinancialsDetailSummaryByType();
				for(FinancialsDetail fd : data) {
					if(fd.getType().equals(tp)) {
						amountType += fd.getAmount();
					}
				}
				typeSingle.setType(tp);
				typeSingle.setAmount(amountType);
				typeSummary.add(typeSingle);
				amountType = 0.0;
			}
			
			return typeSummary;
	
		}
	
	}
