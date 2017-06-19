package com.company.dataanalysis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dataanalysis.model.dao.FinancialsFileToDelete;


public class FinancialsHomepage extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FinancialsFileToDelete deleteFile = new FinancialsFileToDelete();
		deleteFile.deleteFile();
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
