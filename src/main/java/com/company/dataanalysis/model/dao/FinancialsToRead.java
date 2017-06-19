package com.company.dataanalysis.model.dao;

import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.company.dataanalysis.connection.FinancialsFilePath;
import com.company.dataanalysis.model.dto.FinancialsDetail;

public class FinancialsToRead {
	
	
	ArrayList<FinancialsDetail> financials;
	
	public FinancialsToRead() {
		financials = new ArrayList<FinancialsDetail>();
	}
	
	
	public ArrayList<FinancialsDetail> readData() {
		
		String filePath = new FinancialsFilePath().filePath(); //Read file name from directory
		
		try {
			Scanner scanner = new Scanner(new FileReader(filePath));
			scanner.useDelimiter(",");
			String line;
			scanner.nextLine();
			while(scanner.hasNextLine()) {
				line = scanner.nextLine(); // get the line
				String[] results = line.split(","); // split the line on
				FinancialsDetail financial = new FinancialsDetail();	
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				financial.setDate(formatter.parse(results[0]));
				financial.setAmount(Double.parseDouble(results[1]));
				financial.setDescription(results[2]);
				financial.setOperation(results[3]);
				financial.setType(results[4]);
				financial.setCurrency(results[5]);
				financials.add(financial);
			}
			scanner.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return financials;
		
	}
	
	//Temporay data for testing
	public static void main(String[] args) throws ParseException {
		ArrayList<FinancialsDetail> data = new FinancialsToRead().readData();
		
		
		Date startDate = data.get(0).getDate();
		Date endDate = data.get(0).getDate();
		//String initialDateString = "01/01/1900";
		//Date initialDate = formatter.parse(initialDateString);
		for(FinancialsDetail fd : data) {
			if(fd.getDate().before(startDate)) {
				startDate = fd.getDate();
			}
		}
		for(FinancialsDetail fd : data) {
			if(fd.getDate().after(endDate)) {
				endDate = fd.getDate();
			}
		}
		System.out.println(startDate);
		System.out.println(endDate);
		
		
	}
}
