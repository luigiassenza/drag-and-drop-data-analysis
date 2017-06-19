package com.company.dataanalysis.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dataanalysis.model.dao.FinancialsSummaryToReadByDescription;
import com.company.dataanalysis.model.dao.FinancialsSummaryToReadByType;
import com.company.dataanalysis.model.dto.FinancialsDetailSummaryByDescription;
import com.company.dataanalysis.model.dto.FinancialsDetailSummaryByType;


public class FinancialsDashboard extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<FinancialsDetailSummaryByType> summaryByType = new FinancialsSummaryToReadByType().summaryByType();
		request.setAttribute("summaryByType", summaryByType);
		
		ArrayList<FinancialsDetailSummaryByDescription> summaryByDescription = new FinancialsSummaryToReadByDescription().summaryByDescription();
		request.setAttribute("summaryByDescription", summaryByDescription);
		
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
	}

}
