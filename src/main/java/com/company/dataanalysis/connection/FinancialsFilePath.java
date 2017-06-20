package com.company.dataanalysis.connection;

import java.io.File;
import java.util.ArrayList;

public class FinancialsFilePath {
		
		private String directory = "C:\\Users\\User\\Desktop\\analysis\\";
		
		public String filePath() throws InterruptedException {
			Thread.sleep(2000);
			String filePath = "";
			ArrayList<String> fileName = new ArrayList<String>();
			File[] file = new File(directory).listFiles();
			
			for(File f : file) {
				fileName.add(f.getName());
				filePath = directory + f.getName();
				System.out.println(filePath);
			}
			

			//filePath = directory + fileName.get(0);
			return filePath;
		}
		
		public String fileDirectory() {
			return directory;
		}
		/*
		public static void main(String[] args) {
			FinancialsFilePath prova = new FinancialsFilePath();
			System.out.println(prova.filePath());
		}
		*/
}
